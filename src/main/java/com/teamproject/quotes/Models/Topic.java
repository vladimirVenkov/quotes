package com.teamproject.quotes.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="topicid")
    private int id;

    @NotNull
    @Size(min = 3, max = 15, message = "Topic should contain between 3 and 10 characters!")
    @Column(name="topic")
    private String topic;

    public Topic() {
    }

    public Topic(int id, String topic) {

        this.id = id;
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
