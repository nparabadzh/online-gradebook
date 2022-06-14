package com.example.onlinegradebook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="absences")
public class Absences {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "day")
    private Date day;

    @ManyToOne
    SchoolSchedule schoolHour;

    @ManyToOne
    Student student;

    public Absences() {
    }

    public Absences(Date day, SchoolSchedule schoolHour, Student student) {
        this.day = day;
        this.schoolHour = schoolHour;
        this.student = student;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public SchoolSchedule getSchoolHour() {
        return schoolHour;
    }

    public void setSchoolHour(SchoolSchedule schoolHour) {
        this.schoolHour = schoolHour;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
