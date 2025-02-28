package it.unito.iumtweb.springboot.service;

import it.unito.iumtweb.springboot.model.Movie;
import it.unito.iumtweb.springboot.repository.MovieRepository;
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

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }


    public List<Movie> findMovieByName(String name) { // Cambia il tipo di ritorno
        logger.info("Cerco film con nome: {}", name);
        List<Movie> movies = movieRepository.findByName(name); // Usa la variabile movies
        logger.info("Film trovati: {}", movies); // Logga la lista
        return movies;
    }

    // Aggiungi un metodo per salvare un nuovo film (se necessario)
    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }
}