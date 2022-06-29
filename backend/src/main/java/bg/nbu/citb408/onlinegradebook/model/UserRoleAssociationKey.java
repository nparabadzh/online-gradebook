package bg.nbu.citb408.onlinegradebook.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserRoleAssociationKey implements Serializable {

    public UserRoleAssociationKey(){}

    public UserRoleAssociationKey(User user, RoleEntity role) {
        this.user = user;
        this.role = role;
    }

    // bidirectional relationship
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private RoleEntity role;

    public User getUser() {
        return user;
    }

    public RoleEntity getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleAssociationKey that = (UserRoleAssociationKey) o;
        return Objects.equals(user, that.user) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, role);
    }

    @Override
    public String toString() {
        return "UserRoleAssociationKey{" +
                "user=" + user +
                ", role=" + role +
                '}';
    }
}
