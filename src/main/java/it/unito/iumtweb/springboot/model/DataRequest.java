package it.unito.iumtweb.springboot.model;

public class DataRequest {
    private String field1;
    private int field2;
    // ... altri campi

    // Getters e Setters (fondamentali per la deserializzazione JSON)
    public String getField1() { return field1; }
    public void setField1(String field1) { this.field1 = field1; }
    public int getField2() { return field2; }
    public void setField2(int field2) { this.field2 = field2; }
    // ... getters e setters per altri campi
}