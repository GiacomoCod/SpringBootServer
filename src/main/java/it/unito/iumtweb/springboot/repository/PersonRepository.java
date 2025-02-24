package it.unito.iumtweb.springboot.repository;

import it.unito.iumtweb.springboot.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

    Optional<Person> findByNomeAndCognome(String nome, String cognome);

    // Puoi aggiungere altri metodi di query personalizzati qui, se necessario
}