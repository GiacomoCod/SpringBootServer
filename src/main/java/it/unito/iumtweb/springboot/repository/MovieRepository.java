package it.unito.iumtweb.springboot.repository;

import it.unito.iumtweb.springboot.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> { // String è il tipo dell'_id

    List<Movie> findByName(String name); // Per la ricerca per nome

    // findById(String id) è già fornito da MongoRepository (per cercare per _id)
}