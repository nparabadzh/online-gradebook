package com.example.onlinegradebook.model;

import java.util.Date;

public class Topics {
    String topic;
    boolean taken;
    Date takingDate;

    public Topics() {
    }

    public Topics(String topic, boolean taken, Date takingDate) {
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
}
