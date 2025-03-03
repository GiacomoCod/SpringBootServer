package it.unito.iumtweb.springboot.repository;

import it.unito.iumtweb.springboot.model.Poster;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PosterRepository extends MongoRepository<Poster, String> {
    Optional<Poster> findById(int id); // Cerca per l'ID numerico del film
}