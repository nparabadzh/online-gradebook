package bg.nbu.citb408.onlinegradebook.model;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "user", schema = "public")
@SecondaryTable(name = "user_roles", pkJoinColumns=@PrimaryKeyJoinColumn(name="user_id", referencedColumnName="user_id"))
public class UserSecurity {

    @Id
    @Column(name = "user_id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "userRoleAssociationKey.user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRoleAssociation> userRoleAssociation;

    public UserSecurity() {
    }

    public UserSecurity(String id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<UserRoleAssociation> getUserRoleAssociation() {
        return userRoleAssociation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}