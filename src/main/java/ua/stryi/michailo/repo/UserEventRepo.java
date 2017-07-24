package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.entity.UserEvent;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface UserEventRepo extends JpaRepository<UserEvent,Integer> {
    @Query("SELECT a FROM UserEvent a WHERE a.category=:categori")
    public List<UserEvent> findByCategory(@Param("categori") String categori);

    @Query("SELECT a FROM UserEvent a WHERE a.startDate=:date OR a.dateOfCompletion>:date and a.startDate<:date OR a.dateOfCompletion=:date ")
    public List<UserEvent> findByStartDate(@Param("date") GregorianCalendar date);
@Query("SELECT  a FROM UserEvent  a WHERE a.category=:categori AND a.startDate=:date OR a.category=:categori AND a.startDate<:date AND a.dateOfCompletion>:date OR a.category=:categori AND a.dateOfCompletion=:date")
public List<UserEvent> findByCategoryAndDate(@Param("categori") String categori,@Param("date") GregorianCalendar date);
public List<UserEvent> findByAuthor(User user);
}
