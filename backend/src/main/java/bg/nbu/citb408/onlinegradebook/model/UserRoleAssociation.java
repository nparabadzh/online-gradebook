package bg.nbu.citb408.onlinegradebook.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_roles",  schema = "public")
public class UserRoleAssociation implements Serializable {

    @EmbeddedId
    private UserRoleAssociationKey userRoleAssociationKey;

    public UserRoleAssociation() {
    }

    public UserRoleAssociationKey getUserRoleAssociationKey() {
        return userRoleAssociationKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleAssociation that = (UserRoleAssociation) o;
        return Objects.equals(userRoleAssociationKey, that.userRoleAssociationKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userRoleAssociationKey);
    }

    @Override
    public String toString() {
        return "UserRoleAssociation{" +
                "userRoleAssociationKey=" + userRoleAssociationKey +
                '}';
    }
}