package UserManagement.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "user_has_role")
public class UserRoles {


    @Id
    private Integer id;
    private Integer roleId;

    private UUID uuid;

    private String firstName;

    private String lastName;

    private String userName;

    private String roleName;

    public UserRoles(String firstName, String lastName, String userName, UUID uuid, String roleName) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.uuid = uuid;
        this.roleName = roleName;
    }

    public UserRoles() {

    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer userid) {
        this.id = userid;
    }

    public Integer getRoleId() {

        return roleId;
    }

    public void setRoleId(Integer roleId) {

        this.roleId = roleId;
    }


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "uuid=" + uuid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
