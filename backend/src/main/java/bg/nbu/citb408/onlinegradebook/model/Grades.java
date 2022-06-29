package bg.nbu.citb408.onlinegradebook.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="grades")
public class Grades {
    @Id
    @Column(name = "grades_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @Column(name = "grade")
    double grade;

    @Column(name = "date")
    Date date;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = true)
    Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = true)
    Subject subject;

    public Grades() {
    }

    public Grades(double grade, Date date, Student student, Subject subject) {
        this.grade = grade;
        this.date = date;
        this.student = student;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
