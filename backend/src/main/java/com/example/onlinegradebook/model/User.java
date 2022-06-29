package com.example.onlinegradebook.model;

import com.example.onlinegradebook.constant.RoleType;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
    @Id
    @Column(name = "users_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 100)
    String firstName;

    @Column(length = 100)
    String lastName;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

//    @OneToMany(mappedBy = "userRoleAssociationKey.user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<UserRoleAssociation> userRoleAssociation;

    @Column(length = 10)
    String egn;

    @Column(length = 200)
    String address;

    @Column(length = 200)
    String email;

    @Column(name = "role")
    RoleType role;

    @OneToOne
    Employee employee;

    @OneToOne
    Student student;

    @OneToOne
    Parent parent;

    public User() {
    }

    public User(String EGN, String address, RoleType role, Employee employee, Student student, Parent parent) {
        this.egn = EGN;
        this.address = address;
        this.role = role;
        this.employee = employee;
        this.student = student;
        this.parent = parent;
    }

    public User(int id, String email, String password, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String email, String password, String firstName, String lastName, String egn) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.egn = egn;
    }

    public User(String email, String password, String firstName, String lastName, String egn, RoleType role) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.egn = egn;
        this.role = role;
    }

    public User(String email, String password, String firstName, String lastName, String egn, String address, RoleType role) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.egn = egn;
        this.address = address;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEGN() {
        return egn;
    }

    public void setEGN(String EGN) {
        this.egn = EGN;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
