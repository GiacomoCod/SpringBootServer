package it.unito.iumtweb.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "people") // Nome corretto della collection
public class Person {

    @Id
    private String id; // String è un tipo comune per l'ID, ma puoi usare ObjectId se preferisci

    private String nome;
    private String cognome;
    private int eta;      // Usa 'int' se l'età è sempre un intero
    private String città;

    // Getter e Setter (FONDAMENTALI)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public int getEta() { return eta; }
    public void setEta(int eta) { this.eta = eta; }

    public String getCittà() { return città; }
    public void setCittà(String città) { this.città = città; }
}