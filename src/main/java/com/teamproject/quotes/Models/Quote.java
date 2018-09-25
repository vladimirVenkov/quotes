package com.teamproject.quotes.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quoteid")
    private int id;

    @ManyToOne
    @JoinColumn(name = "authorid")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "topicid")
    private Topic topic;

    @NotNull
    @Size(min = 10, message = "Only quotes with 10 or more characters are accepted!")
    @Column(name = "quote")
    private String quote;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Quote() {

    }

    public Quote(Author author, Topic topic, String quote, String url) {
        this.author = author;
        this.topic = topic;
        this.quote = quote;
        this.imageUrl = url;
        isDeleted = false;
    }

    public Quote(int id, Author author, Topic topic, String quote, String url) {
        this.id = id;
        this.author = author;
        this.topic = topic;
        this.quote = quote;
        this.imageUrl = url;
        isDeleted = false;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthorName() {
        return author;
    }

    public void setAuthorName(Author author) {
        this.author = author;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
