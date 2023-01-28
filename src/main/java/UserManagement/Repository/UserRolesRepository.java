package UserManagement.Repository;

import UserManagement.Model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRolesRepository extends JpaRepository<UserRoles, UserRoles> {
   @Query(value = "SELECT u.uuid, u.user_name, r.role_name FROM user_has_role ur JOIN users u ON u.uuid = ur.uuid JOIN roles r ON r.role_id = ur.role_id",
      nativeQuery = true)

    List<Object[]> findAllRoles();


}
