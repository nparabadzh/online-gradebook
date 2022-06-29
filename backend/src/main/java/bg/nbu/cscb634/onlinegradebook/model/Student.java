package bg.nbu.cscb634.onlinegradebook.model;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    @JoinColumn(name = "class_id", nullable = false)
    SchoolClass schoolClass;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    User user;

    public Student() {
    }

    public Student(User user, SchoolClass schoolClassIn) {
        this.user = user;
        this.schoolClass = schoolClassIn;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
