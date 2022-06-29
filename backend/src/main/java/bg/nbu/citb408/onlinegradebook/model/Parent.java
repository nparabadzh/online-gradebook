package bg.nbu.citb408.onlinegradebook.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="parents")
public class Parent{

    @Id
    @Column(name = "parent_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;

    @OneToMany
    List<Student> students;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    User user;

    public Parent() {
        this.students = new ArrayList<>();
    }

    public Parent(User user, List<Student> students) {
        this.students = students;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
