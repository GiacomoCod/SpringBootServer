package it.unito.iumtweb.springboot.controller;

import it.unito.iumtweb.springboot.model.DataRequest; // Per ricevere dati da Node.js
import it.unito.iumtweb.springboot.model.Person;     // Per salvare i dati nel database
import it.unito.iumtweb.springboot.service.PersonService;   // Per la logica di business
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DataController {

    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private PersonService personService;

    // Endpoint per RICEVERE dati da Node.js e SALVARLI nel database
    @PostMapping("/receiveData")
    public ResponseEntity<String> receiveData(@RequestBody DataRequest data) {
        logger.info("Richiesta ricevuta da Node.js:");
        logger.info("Campo 1: {}", data.getField1());
        logger.info("Campo 2: {}", data.getField2());

        // Crea un oggetto Person
        Person person = new Person();
        person.setNome(data.getField1());       // Imposta il nome
        person.setEta(data.getField2());        // Imposta l'età
        // Imposta valori temporanei per cognome e città (o prendili da qualche altra parte)
        person.setCognome("Sconosciuto");
        person.setCittà("Sconosciuta");

        try {
            personService.salvaPersona(person); // Salva la persona nel database
            logger.info("Dati salvati con successo.");
            return new ResponseEntity<>("Dati ricevuti, elaborati e salvati.", HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Errore durante il salvataggio dei dati: ", e);
            return new ResponseEntity<>("Errore durante il salvataggio.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint per OTTENERE la città di una persona, dati nome e cognome
    @GetMapping("/getCitta")
    public ResponseEntity<String> getCitta(
            @RequestParam("nome") String nome,
            @RequestParam("cognome") String cognome) {

        Optional<String> citta = personService.trovaCittaPerNomeECognome(nome, cognome);

        return citta.map(s -> new ResponseEntity<>(s, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Persona non trovata.", HttpStatus.NOT_FOUND));
    }
}