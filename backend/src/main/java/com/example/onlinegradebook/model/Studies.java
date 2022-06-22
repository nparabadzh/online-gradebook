package com.example.onlinegradebook.model;


import javax.persistence.*;

@Entity
@Table(name="studies")
public class Studies {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private SchoolClass schoolClass;

    public Studies() {
    }

    public Studies(SchoolClass schoolClass, Subject subject) {
        this.schoolClass = schoolClass;
        this.subject = subject;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getID(){
        return id;
    }
}
