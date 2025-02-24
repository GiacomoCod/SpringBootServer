package it.unito.iumtweb.springboot.service;

import it.unito.iumtweb.springboot.model.Person;
import it.unito.iumtweb.springboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person salvaPersona(Person person) {
        return personRepository.save(person);
    }

    public Optional<String> trovaCittaPerNomeECognome(String nome, String cognome) {
        Optional<Person> person = personRepository.findByNomeAndCognome(nome, cognome);
        return person.map(Person::getCittà); // Usa la method reference
    }

    // Puoi aggiungere altri metodi qui, se necessario (es. findAll, delete, ecc.)
}