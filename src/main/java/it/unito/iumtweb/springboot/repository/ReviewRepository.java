package it.unito.iumtweb.springboot.repository;

import it.unito.iumtweb.springboot.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByMovieTitle(String movieTitle); // Metodo chiave per trovare le recensioni per titolo
}