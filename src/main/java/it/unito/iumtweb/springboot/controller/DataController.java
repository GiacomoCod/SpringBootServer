// controller/DataController.java
package it.unito.iumtweb.springboot.controller;

import it.unito.iumtweb.springboot.model.DataRequest;
import it.unito.iumtweb.springboot.model.Person;
import it.unito.iumtweb.springboot.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DataController {

    private static final Logger logger = LoggerFactory.getLogger(DataController.class); // Crea il logger

    @Autowired
    private PersonService personService;

    @PostMapping("/receiveData")
    public ResponseEntity<String> receiveData(@RequestBody DataRequest data) {
        logger.info("Richiesta POST a /receiveData ricevuta."); // Log di livello INFO
        logger.debug("Dati ricevuti: {}", data); // Log di livello DEBUG (più dettagliato)

        Person person = new Person();
        person.setNome(data.getField1());
        person.setEta(data.getField2());
        person.setCognome("Sconosciuto");
        person.setCitta("Sconosciuta");

        try {
            personService.salvaPersona(person);
            logger.info("Persona salvata con successo.");
        } catch (Exception e) {
            logger.error("Errore durante il salvataggio: ", e); // Log di livello ERROR, include l'eccezione
            return new ResponseEntity<>("Errore durante il salvataggio.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Dati ricevuti, elaborati e salvati.", HttpStatus.OK);
    }

    @GetMapping("/getCitta")
    public ResponseEntity<String> getCitta(
            @RequestParam("nome") String nome,
            @RequestParam("cognome") String cognome) {

        logger.info("Richiesta GET a /getCitta ricevuta.");
        logger.debug("Nome: {}, Cognome: {}", nome, cognome); // Log dei parametri con formattazione

        Optional<String> citta = personService.trovaCittaPerNomeECognome(nome, cognome);

        if (citta.isPresent()) {
            logger.info("Città trovata: {}", citta.get());
            return new ResponseEntity<>(citta.get(), HttpStatus.OK);
        } else {
            logger.warn("Persona non trovata per nome: {} e cognome: {}", nome, cognome); // Log di livello WARN
            return new ResponseEntity<>("Persona non trovata.", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllPeople") //nuovo mapping
    public ResponseEntity<List<Person>> getAllPeople() {
        List<Person> people = personService.findAllPeople();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/mario") //nuovo mapping
    public ResponseEntity<String> mario() {

        Optional<String> citta = personService.trovaCittaPerNomeECognome("Mario", "Rossi");

        if (citta.isPresent()) {
            logger.info("Città trovata: {}", citta.get());
            return new ResponseEntity<>(citta.get(), HttpStatus.OK);
        } else {
            logger.warn("Persona non trovata per nome: {} e cognome: {}", "Mario", "Rossi"); // Log di livello WARN
            return new ResponseEntity<>("Persona non trovata.", HttpStatus.NOT_FOUND);
        }
    }



}