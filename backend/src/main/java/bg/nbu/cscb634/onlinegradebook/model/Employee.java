package bg.nbu.cscb634.onlinegradebook.model;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee{

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "qualification")
    String qualification;

    @Column(name = "salary")
    double salary;

    @OneToOne
    @JoinColumn(name = "school_id", nullable = false)
    School school;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    User user;

    public Employee() {
    }

    public Employee(User user, String qualification, double salary, School school) {
        this.user = user;
        this.qualification = qualification;
        this.salary = salary;
        this.school = school;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
