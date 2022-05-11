package com.example.onlinegradebook.model;


import javax.persistence.*;

@Entity
@Table(name="studies")
public class Studies {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Subjects subject;

    @ManyToOne
    private Student student;

    @Column(name = "grade")
    private double grade;

    public Studies() {
    }

    public Studies(Student student, Subjects subject, double grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
