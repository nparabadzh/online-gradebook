package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.AbsenceStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="absences")
public class Absence {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "day")
    private Date day;

    @Column(name = "absenceStatus")
    private AbsenceStatus status;

    @ManyToOne
    SchoolSchedule schoolHour;

    @ManyToOne
    Student student;

    public Absence() {
    }

    public Absence(Date day, SchoolSchedule schoolHour, Student student, AbsenceStatus absenceStatus) {
        this.day = day;
        this.schoolHour = schoolHour;
        this.student = student;
        this.status = absenceStatus;
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

    public int getID(){
        return id;
    }

    public AbsenceStatus getStatus() {
        return status;
    }

    public void setStatus(AbsenceStatus status) {
        this.status = status;
    }
}
