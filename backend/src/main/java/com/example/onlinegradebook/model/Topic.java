package com.example.onlinegradebook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="topics")
public class Topic {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "topic")
    private String topic;

    @Column(name = "is_taken")
    private boolean taken;

    @Column(name = "taking_date")
    private Date takingDate;

    public Topic() {

    }

    public Topic(String topic, boolean taken, Date takingDate) {
        this.topic = topic;
        this.taken = taken;
        this.takingDate = takingDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public Date getTakingDate() {
        return takingDate;
    }

    public void setTakingDate(Date takingDate) {
        this.takingDate = takingDate;
    }

    public int getID(){
        return id;
    }
}
