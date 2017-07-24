package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.stryi.michailo.entity.Friends;
import ua.stryi.michailo.entity.User;

/**
 * Created by михайло on 08.05.2017.
 */
public interface FriendsRepo extends JpaRepository<Friends,Integer> {
    public Friends findByUser(User user);


}
