package com.example.onlinegradebook.model;

public class Studies {
    Students student;
    Subjects subject;
    double grade;

    public Studies() {
    }

    public Studies(Students student, Subjects subject, double grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
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
