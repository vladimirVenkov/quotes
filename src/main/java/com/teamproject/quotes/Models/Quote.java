package com.teamproject.quotes.Models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Quote {

    private int id;

    @NotNull
    @Size(min = 2, message = "Author's name should be at least 2 characters long!")
    private String authorName;

    @NotNull
    @Size(min = 3, max = 15, message = "Topic should contain between 3 and 10 characters!")
    private String topic;

    @NotNull
    @Size(min = 10, message = "Only quotes with 10 or more characters are accepted!")
    private String quote;

    private String imageUrl;
    private boolean isDeleted;

    public Quote() {

    }

    public Quote(String authorName, String topic, String quote, String url) {
        this.authorName = authorName;
        this.topic = topic;
        this.quote = quote;
        this.imageUrl = url;
        isDeleted = false;
    }

    public Quote(int id, String authorName, String topic, String quote, String url) {
        this.id = id;
        this.authorName = authorName;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
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
