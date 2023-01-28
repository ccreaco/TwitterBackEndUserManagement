package UserManagement.Model;


import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;
import java.util.Date;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

   @Type(type="org.hibernate.type.UUIDCharType")
   private UUID uuid = UUID.randomUUID();

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private Date lastVisitOut;

    private Date lastVisitIn;




    public Users(String firstName, String lastName, String userName, String password, UUID uuid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.uuid = uuid;
    }


    public Users() {

    }



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer id) {
        this.userId = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   public  UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


    public Date getLastVisitOut() {
        return lastVisitOut;
    }

    public void setLastVisitOut(Date lastVisitOut) {
        this.lastVisitOut = lastVisitOut;
    }

    public Date getLastVisitIn() {
        return lastVisitIn;
    }

    public void setLastVisitIn(Date lastVisitIn) {
        this.lastVisitIn = lastVisitIn;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", uuid=" + uuid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastVisitOut=" + lastVisitOut +
                ", lastVisitIn=" + lastVisitIn +
                '}';
    }

}
