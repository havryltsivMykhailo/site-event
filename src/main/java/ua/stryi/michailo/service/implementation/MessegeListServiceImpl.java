package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.stryi.michailo.entity.Message;
import ua.stryi.michailo.entity.MessageList;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.repo.MessegeListRepo;
import ua.stryi.michailo.service.MessegeListService;
import ua.stryi.michailo.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by михайло on 18.05.2017.
 */
@Service
public class MessegeListServiceImpl implements MessegeListService {
@Autowired
    MessegeListRepo messegeListRepo;
@Autowired
UserService userService;
    @Override
    public List<MessageList> getMessageList() {
        if (messegeListRepo.findByUser(userService.authenticationUser())!=null){
            return messegeListRepo.findByUser(userService.authenticationUser());
        }
        return null;
    }

    @Override
    public void addMessageList(Message message, Integer id) {
        User user1=userService.authenticationUser();
        User user2=userService.FindById(id);

        if (messegeListRepo.findByUserAndUserMesage(user1,user2)!=null){
            MessageList messageList=messegeListRepo.findByUserAndUserMesage(user1,user2);
            messageList.getMessageLists().add(message);
            messageList.setMessage(message.getMessage());


            MessageList   messageList2=messegeListRepo.findByUserAndUserMesage(user2,user1);
            messageList2.getMessageLists().add(message);
            messageList2.setMessage(message.getMessage());



            messegeListRepo.save(messageList);
            messegeListRepo.save(messageList2);
        }else {
            MessageList messageList1=new MessageList();
            messageList1.setName(user2.getName());
            messageList1.setUser(user1);
            messageList1.setUserMesage(user2);
            List<Message> messages=new ArrayList<>();
            messages.add(message);
            messageList1.setMessageLists(messages);
            messageList1.setMessage(message.getMessage());


            MessageList messageList2=new MessageList();
            messageList2.setName(user1.getName());
            messageList2.setUser(user2);
            messageList2.setUserMesage(user1);
            List<Message> messages2=new ArrayList<>();
            messages2.add(message);
            messageList2.setMessageLists(messages2);
            messageList2.setMessage(message.getMessage());


            messegeListRepo.save(messageList1);
            messegeListRepo.save(messageList2);
        }

    }
}
