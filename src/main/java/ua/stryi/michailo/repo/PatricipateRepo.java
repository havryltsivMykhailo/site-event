package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.stryi.michailo.entity.Participate;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.entity.UserEvent;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface PatricipateRepo extends JpaRepository<Participate,Integer> {
    public Participate findByEventAndUser(UserEvent event, User user);
    public List<Participate> findByEvent(UserEvent userEvent);
    public List<Participate> findByUser(User user);
}
