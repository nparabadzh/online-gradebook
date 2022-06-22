package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.AbsenceStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="absences")
public class Absence {

    @Id
    @Column(name = "absence_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name = "day")
    Date day;

    @Column(name = "absenceStatus")
    AbsenceStatus status;

    @ManyToOne
    @JoinColumn(name = "school_schedule_id", nullable = true)
    SchoolSchedule schoolHour;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = true)
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

    public AbsenceStatus getStatus() {
        return status;
    }

    public void setStatus(AbsenceStatus status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
