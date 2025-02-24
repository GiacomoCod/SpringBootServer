package it.unito.iumtweb.springboot.repository; // Crea questo package

import it.unito.iumtweb.springboot.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // Opzionale, ma consigliato
public interface DataRepository extends MongoRepository<Data, String> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario.
    // Per ora, i metodi di base di MongoRepository sono sufficienti.

}