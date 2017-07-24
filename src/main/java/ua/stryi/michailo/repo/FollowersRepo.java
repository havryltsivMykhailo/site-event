package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.stryi.michailo.entity.Followers;
import ua.stryi.michailo.entity.User;

/**
 * Created by михайло on 08.05.2017.
 */
public interface FollowersRepo extends JpaRepository<Followers,Integer> {
    public Followers findByUser(User user);
}
