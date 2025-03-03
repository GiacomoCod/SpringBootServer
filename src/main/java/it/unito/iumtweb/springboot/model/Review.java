package it.unito.iumtweb.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime; // Per la data
import java.time.format.DateTimeFormatter;

@Document(collection = "rotten_tomatoes_reviews") // Assicurati che il nome della collection sia corretto
public class Review {

    @Id
    private String id; // _id di MongoDB

    @Field("rotten_tomatoes_link")
    private String rottenTomatoesLink;

    @Field("movie_title")
    private String movieTitle;

    @Field("critic_name")
    private String criticName;

    @Field("top_critic")
    private boolean topCritic;

    @Field("publisher_name")
    private String publisherName;

    @Field("review_type")
    private String reviewType;

    @Field("review_date")
    private LocalDateTime reviewDate; // Usa LocalDateTime per la data

    @Field("review_content")
    private String reviewContent;

    // Costruttore vuoto (necessario per Spring Data)
    public Review() {}

    // Costruttore con parametri (opzionale, ma utile)

    // Getter e Setter (per tutti i campi)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getRottenTomatoesLink() {
        return rottenTomatoesLink;
    }

    public void setRottenTomatoesLink(String rottenTomatoesLink) {
        this.rottenTomatoesLink = rottenTomatoesLink;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    public String getCriticName() {
        return criticName;
    }

    public void setCriticName(String criticName) {
        this.criticName = criticName;
    }
    public boolean isTopCritic() {
        return topCritic;
    }

    public void setTopCritic(boolean topCritic) {
        this.topCritic = topCritic;
    }
    public String getPublisherName() {
        return publisherName;
    }
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
    public String getReviewType() {
        return reviewType;
    }

    public void setReviewType(String reviewType) {
        this.reviewType = reviewType;
    }
    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }
}