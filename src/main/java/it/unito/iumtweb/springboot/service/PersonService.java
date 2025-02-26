package it.unito.iumtweb.springboot.service;

import it.unito.iumtweb.springboot.model.Person;
import it.unito.iumtweb.springboot.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class); // Logger

    @Autowired
    private PersonRepository personRepository;

    public Person salvaPersona(Person person) {
        return personRepository.save(person);
    }

    public Optional<String> trovaCittaPerNomeECognome(String nome, String cognome) {

        Optional<Person> person = personRepository.findByNomeAndCognome(nome, cognome);

        return person.map(Person::getCitta); // Usa la method reference
    }

    public List<Person> findAllPeople() { // Nuovo metodo per ottenere tutte le persone
        List<Person> people = personRepository.findAll();
        logger.info("Tutte le persone: {}", people); // Log di tutte le persone
        return people;
    }

    // Puoi aggiungere altri metodi qui, se necessario (es. findAll, delete, ecc.)
}