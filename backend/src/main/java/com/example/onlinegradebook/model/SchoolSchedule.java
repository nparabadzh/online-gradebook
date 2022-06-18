package com.example.onlinegradebook.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="school_schedule")
public class SchoolSchedule {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "week_day")
    private WeekDay weekDay;

    @ManyToOne
    private Subject subject;

    @Column(name = "class_for")
    private Class classFor;

    @Column(name = "starts_at")
    private Time startsAt;

    @Column(name = "ends_at")
    private Time endsAt;

    public SchoolSchedule() {
    }

    public SchoolSchedule(WeekDay weekDay, Subject subject, Class classFor, Time startsAt, Time endsAt) {
        this.weekDay = weekDay;
        this.subject = subject;
        this.classFor = classFor;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Class getClassFor() {
        return classFor;
    }

    public void setClassFor(Class classFor) {
        this.classFor = classFor;
    }

    public Time getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Time startsAt) {
        this.startsAt = startsAt;
    }

    public Time getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(Time endsAt) {
        this.endsAt = endsAt;
    }
}
