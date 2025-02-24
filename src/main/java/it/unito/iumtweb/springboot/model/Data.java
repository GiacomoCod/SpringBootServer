package it.unito.iumtweb.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "datiRicevuti") // Scegli un nome significativo per la collection
public class Data {

    @Id
    private String id; // ObjectId o String, a seconda delle tue esigenze

    // Mappa i campi di DataRequest ai campi dell'entità.
    // Puoi usare @Field se i nomi dei campi nel database sono diversi.
    @Field("campo1") // Esempio di uso di @Field
    private String field1;

    @Field("campo2")
    private int field2;

    private String nome; // Assicurati di avere questi campi
    private String cognome;
    private String citta;

    // ... altri campi, se necessario, corrispondenti a quelli di DataRequest

    // Getter e Setter (IMPORTANTE!)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getField1() { return field1; }
    public void setField1(String field1) { this.field1 = field1; }
    public int getField2() { return field2; }
    public void setField2(int field2) { this.field2 = field2; }

    // ... altri getter e setter
}