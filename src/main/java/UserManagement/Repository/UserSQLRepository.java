package UserManagement.Repository;

import UserManagement.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.UUID;

public interface UserSQLRepository extends JpaRepository<Users, Integer> {

    List<Users> findByUuid(UUID uuid);

    List<Users> deleteByUuid(UUID uuid);


}
