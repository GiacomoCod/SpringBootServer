package it.unito.iumtweb.springboot.controller;

import it.unito.iumtweb.springboot.model.Person;
import it.unito.iumtweb.springboot.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; //Aggiunto per testare il post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DataControllerTest {

    @Autowired
    private MockMvc mockMvc; // Per simulare richieste HTTP

    @MockBean // Mock del service (per isolare il test del controller)
    private PersonService personService;

    @Test
    void testGetCitta_Success() throws Exception {
        // 1. Prepara il mock del service
        when(personService.trovaCittaPerNomeECognome("Mario", "Rossi"))
                .thenReturn(Optional.of("Roma"));

        // 2. Esegui la richiesta HTTP simulata
        mockMvc.perform(get("/getCitta")
                        .param("nome", "Mario")
                        .param("cognome", "Rossi")
                        .contentType(MediaType.APPLICATION_JSON)) // Buona pratica, anche se non strettamente necessario qui
                // 3. Verifica la risposta
                .andExpect(status().isOk()) // Verifica che lo status sia 200 OK
                .andExpect(content().string("Roma")); // Verifica che il corpo della risposta sia "Roma"
    }

    @Test
    void testGetCitta_NotFound() throws Exception {
        // 1. Prepara il mock del service
        when(personService.trovaCittaPerNomeECognome("Pippo", "Pluto"))
                .thenReturn(Optional.empty()); // Simula persona non trovata

        // 2. Esegui la richiesta
        mockMvc.perform(get("/getCitta")
                        .param("nome", "Pippo")
                        .param("cognome", "Pluto"))
                // 3. Verifica la risposta
                .andExpect(status().isNotFound()) // Verifica che lo status sia 404 Not Found
                .andExpect(content().string("Persona non trovata.")); //Verifica body
    }

    @Test
    void testGetCitta_MissingParams() throws Exception{
        mockMvc.perform(get("/getCitta"))
                .andExpect(status().isBadRequest()); //Verifica 400 Bad Request se mancano i parametri
    }
    @Test
    void testReceiveData_Success() throws Exception {
        Person person = new Person(); //creo oggetto di tipo Person
        person.setNome("test");
        person.setCognome("test");
        person.setEta(10);
        person.setCitta("test");

        when(personService.salvaPersona(person)).thenReturn(person);
        mockMvc.perform(post("/receiveData")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"field1\": \"test\", \"field2\": 10}")) // Simula il JSON inviato da Node.js
                .andExpect(status().isOk());
    }

//    @Test
//    void testReceiveData_Error() throws Exception{
//
//        when(personService.salvaPersona(new Person())).thenThrow(new RuntimeException());
//
//        mockMvc.perform(post("/receiveData")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"field1\": \"test\", \"field2\": 10}")) // Simula dati non corretti
//                .andExpect(status().isInternalServerError());
//    }
}