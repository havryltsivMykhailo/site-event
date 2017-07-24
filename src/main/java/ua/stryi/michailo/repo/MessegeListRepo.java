package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.stryi.michailo.entity.MessageList;
import ua.stryi.michailo.entity.User;

import java.util.List;

/**
 * Created by михайло on 18.05.2017.
 */
public interface MessegeListRepo extends JpaRepository<MessageList,Integer > {
    public MessageList findByUserAndUserMesage(User user1,User user2);
    public List<MessageList>findByUser(User user);
}
