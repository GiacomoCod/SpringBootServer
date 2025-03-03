package it.unito.iumtweb.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "posters")
public class Poster {

    @Id
    private String idMongo; // _id di MongoDB

    @Field("id")
    private int id; // L'ID numerico del film (intero)

    private String link; // L'URL della locandina

    // Costruttore vuoto (necessario per Spring Data)
    public Poster() {}

    // Costruttore con parametri (opzionale)
    public Poster(String idMongo, int id, String link) {
        this.idMongo = idMongo;
        this.id = id;
        this.link = link;
    }

    // Getter e Setter
    public String getIdMongo() { return this.idMongo;}
    public void setIdMongo(String idMongo){ this.idMongo = idMongo;}
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
}