package it.unito.iumtweb.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "movies")
public class Movie {

    @Id
    private String id;  // Usa String per l'_id generato da MongoDB, anche se nel tuo esempio è int


    @Field("id")
    private int movieId;

    private String name;

    // Usa java.time.LocalDate o java.time.Year, a seconda della precisione che ti serve
    // Se usi int, dovrai fare la conversione (es. 2024 -> LocalDate.of(2024, 1, 1))
    // private int date; // Sconsigliato per le date
    @Field("date")
    private int year; //Per semplicità, nel model, salviamo solo l'anno

    private String tagline;
    private String description;
    private int minute;

    // Usa Double se hai bisogno di maggiore precisione (es. 7.5)
    private float rating;

    private String poster; //URL della locandina

    // Costruttore vuoto (necessario per Spring Data MongoDB)
    public Movie() {}

    // Costruttore (opzionale, ma utile)
    public Movie(String name, int year, String tagline, String description, int minute, float rating) {
        this.name = name;
        this.year = year;
        this.tagline = tagline;
        this.description = description;
        this.minute = minute;
        this.rating = rating;
    }

    // Getters and Setters (FONDAMENTALI)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getTagline() { return tagline; }
    public void setTagline(String tagline) { this.tagline = tagline; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getMinute() { return minute; }
    public void setMinute(int minute) { this.minute = minute; }

    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }
    //toString

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", tagline='" + tagline + '\'' +
                ", description='" + description + '\'' +
                ", minute=" + minute +
                ", rating=" + rating +
                '}';
    }
}