package com.example.onlinegradebook.model;

import java.util.Date;

public class Absences {
    Date day;
    SchoolSchedule schoolHour;
    Students student;

    public Absences() {
    }

    public Absences(Date day, SchoolSchedule schoolHour, Students student) {
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

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }
}
