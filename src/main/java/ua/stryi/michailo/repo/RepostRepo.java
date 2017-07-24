package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.stryi.michailo.entity.Repost;
import ua.stryi.michailo.entity.User;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface RepostRepo extends JpaRepository<Repost,Integer> {
    public List<Repost> findByUser(User user);
}
