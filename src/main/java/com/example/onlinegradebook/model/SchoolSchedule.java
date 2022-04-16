package com.example.onlinegradebook.model;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.temporal.WeekFields;
import java.util.List;

public class SchoolSchedule {
    WeekDays weekDay;
    Subjects subject;
    Classes classFor;
    Time startsAt;
    Time endsAt;

    public SchoolSchedule() {
    }

    public SchoolSchedule(WeekDays weekDay, Subjects subject, Classes classFor, Time startsAt, Time endsAt) {
        this.weekDay = weekDay;
        this.subject = subject;
        this.classFor = classFor;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }

    public WeekDays getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDays weekDay) {
        this.weekDay = weekDay;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    public Classes getClassFor() {
        return classFor;
    }

    public void setClassFor(Classes classFor) {
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
