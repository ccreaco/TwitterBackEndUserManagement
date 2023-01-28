package UserManagement.Repository;
import UserManagement.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleSQLRepository extends JpaRepository<Roles, Integer>{

}
