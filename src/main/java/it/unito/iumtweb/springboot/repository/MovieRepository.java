package it.unito.iumtweb.springboot.repository;

import it.unito.iumtweb.springboot.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    // Puoi aggiungere metodi di query personalizzati qui, se necessario

    List<Movie> findByName(String name); // Restituisce una List<Movie>
}