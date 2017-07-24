package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.stryi.michailo.entity.Message;
import ua.stryi.michailo.entity.User;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface MessageRepo extends JpaRepository<Message,Integer>{
    List<Message> findByRecipientAndSender(User recipient,User sender);
    List<Message> findBySenderAndRecipient(User sender,User recipient);
    @Query("SELECT u FROM Message u WHERE u.sender=:sender AND u.recipient=:recipient AND u.id>:id")
    List<Message> findBySenderAndRecipientNew(@Param("sender") User sender,@Param("recipient") User recipient,@Param("id") Integer id);


}
