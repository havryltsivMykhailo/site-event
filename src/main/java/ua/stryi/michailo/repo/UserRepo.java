package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.stryi.michailo.entity.User;

import java.util.List;

/**
 * Created by михайло on 07.05.2017.
 */

public interface UserRepo extends JpaRepository<User,Integer>{

User findByEmailOrPhone(String email,String phone);
User findByActivator(String activator);
User findByEmail(String email);
@Query("SELECT  a FROM  User a WHERE a.name=:name OR a.secondName=:name")
List<User> findByUser(@Param("name") String name);
@Query("SELECT a FROM User  a Where a.name=:name and a.secondName=:secondName OR a.name=:secondName AND a.secondName=:name")
List<User> findByNameAndSecondName(@Param("name") String name,@Param("secondName") String secondName);

}
