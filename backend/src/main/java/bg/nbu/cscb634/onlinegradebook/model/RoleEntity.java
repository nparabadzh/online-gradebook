package bg.nbu.cscb634.onlinegradebook.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;


@Entity
@Table(name = "role", schema = "public")
public class RoleEntity implements Serializable {
    private static final long serialVersionUID = 1L;
//    public static final String USER = "USER";
//    public static final String ADMIN = "ADMIN";

    public static final String ROLE_TEACHER = "TEACHER";
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_STUDENT = "STUDENT";

    @Id
    @Column(name = "role_id")
    private String roleId;

    @Column(name = "role_name")
    private String name;

    public RoleEntity() {
    }


    public String getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(name, ((RoleEntity) obj).getName());
    }


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Role [name=").append(name).append("]").append("[id=").append(roleId).append("]");
        return builder.toString();
    }
}