package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.stryi.michailo.entity.Followings;
import ua.stryi.michailo.entity.User;

/**
 * Created by михайло on 25.06.2017.
 */
public interface FollowingsRepo extends JpaRepository<Followings,Integer> {
    public Followings findByUser(User user);
}
