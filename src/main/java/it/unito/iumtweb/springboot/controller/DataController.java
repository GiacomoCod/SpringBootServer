package it.unito.iumtweb.springboot.controller;

import it.unito.iumtweb.springboot.model.DataRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private static final Logger logger = LoggerFactory.getLogger(DataController.class);

    @PostMapping("/receiveData") // URL endpoint per ricevere i dati
    public ResponseEntity<String> receiveData(@RequestBody DataRequest data) {
        logger.info("Richiesta ricevuta da Node.js:");
        logger.info("Campo 1: {}", data.getField1());
        logger.info("Campo 2: {}", data.getField2());
        // ... log di altri campi

        // --- Esegui qui la logica di elaborazione dei dati ---
        // Ad esempio, puoi salvare i dati in un database,
        // elaborarli ulteriormente, o chiamare altri servizi.

        try {
            // Simulazione di elaborazione (sostituisci con la tua logica)
            Thread.sleep(500); // Simula un ritardo di elaborazione
            logger.info("Dati elaborati con successo.");
            return new ResponseEntity<>("Dati ricevuti ed elaborati.", HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Errore durante l'elaborazione dei dati: ", e);
            return new ResponseEntity<>("Errore durante l'elaborazione.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}