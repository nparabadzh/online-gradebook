package bg.nbu.citb408.onlinegradebook.model;

import bg.nbu.citb408.onlinegradebook.constant.Year;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @OneToOne
    Employee teacher;

    @OneToMany
    List<Topic> topics;

    @Column(name = "intended_for")
    Year intendedFor;

    @OneToMany
    @JoinColumn(name = "student_id", nullable = true)
    List<Grades> grades;

    public Subject() {

    }

    public Subject(Year intendedFor) {
        this.intendedFor = intendedFor;
    }

    public Subject(Employee teacher, List<Topic> topics, Year intendedFor) {
        this.teacher = teacher;
        this.topics = topics;
        this.intendedFor = intendedFor;
    }

       public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public Year getIntendedFor() {
        return intendedFor;
    }

    public void setIntendedFor(Year intendedFor) {
        this.intendedFor = intendedFor;
    }

    public Employee getTeacher() {
        return teacher;
    }

    public void setTeacher(Employee teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Grades> getGrades() {
        return grades;
    }

    public void setGrades(List<Grades> grades) {
        this.grades = grades;
    }
}
