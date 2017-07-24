package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.stryi.michailo.entity.PerhapsParticipate;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.entity.UserEvent;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface PerhapsParticipateRepo extends JpaRepository<PerhapsParticipate,Integer> {
    public PerhapsParticipate findByEventAndUser(UserEvent event, User user);
    public List<PerhapsParticipate> findByEvent(UserEvent userEvent);
}
