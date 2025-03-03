package it.unito.iumtweb.springboot.service;

import it.unito.iumtweb.springboot.model.Movie;
import it.unito.iumtweb.springboot.model.Poster;
import it.unito.iumtweb.springboot.repository.MovieRepository;
import it.unito.iumtweb.springboot.repository.PosterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class); // Logger

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private PosterRepository posterRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public List<Movie> findMovieByName(String name) { // Cambia il tipo di ritorno
        logger.info("Cerco film con nome: {}", name);
        List<Movie> movies = movieRepository.findByName(name); // Usa la variabile movies

        // Aggiungi il poster URL ad ogni film trovato
        movies.forEach(movie -> {
            Optional<Poster> poster = posterRepository.findById(movie.getMovieId());
            poster.ifPresent(p -> movie.setPoster(p.getLink()));
        });

        logger.info("Film trovati: {}", movies); // Logga la lista
        return movies;
    }

    // Aggiungi un metodo per salvare un nuovo film (se necessario)
    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Optional<Movie> findMovieById(String id) {
        logger.info("Cerco film con ID: {}", id);
        try {
            Optional<Movie> movieOptional  = movieRepository.findById(id); // Usa findById di MongoRepository
            movieOptional .ifPresent(movie -> {
                Optional<Poster> poster = posterRepository.findById(movie.getMovieId());
                poster.ifPresent(p -> movie.setPoster(p.getLink()));
            });
            logger.info("Film trovato (da repository per ID): {}", movieOptional );
            return movieOptional ;
        } catch (Exception e) {
            logger.error("Errore durante la ricerca del film per ID: {}", id, e);
            throw e; // Rilancia l'eccezione
        }

    }

}