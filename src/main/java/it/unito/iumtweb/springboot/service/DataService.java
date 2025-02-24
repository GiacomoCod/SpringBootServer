package it.unito.iumtweb.springboot.service; // Crea questo package

import it.unito.iumtweb.springboot.controller.DataController;
import it.unito.iumtweb.springboot.model.Data;
import it.unito.iumtweb.springboot.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DataService {

    @Autowired
    private DataRepository datoRicevutoRepository;

    public Data salvaDato(Data dato) {
        return datoRicevutoRepository.save(dato);
    }

    // Aggiungi altri metodi qui, se necessario (es. per la ricerca, l'eliminazione, ecc.)
}