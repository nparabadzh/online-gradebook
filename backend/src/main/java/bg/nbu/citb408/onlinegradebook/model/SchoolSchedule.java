package bg.nbu.citb408.onlinegradebook.model;

import bg.nbu.citb408.onlinegradebook.constant.WeekDay;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="school_schedule")
public class SchoolSchedule {

    @Id
    @Column(name = "school_schedule_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name = "week_day")
    WeekDay weekDay;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = true)
    Subject subject;

    @Column(name = "starts_at")
    Time startsAt;

    @Column(name = "ends_at")
    Time endsAt;

    public SchoolSchedule() {
    }

    public SchoolSchedule(WeekDay weekDay, Subject subject, Time startsAt, Time endsAt) {
        this.weekDay = weekDay;
        this.subject = subject;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
