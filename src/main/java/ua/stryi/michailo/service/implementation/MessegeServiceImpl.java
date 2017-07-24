package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.stryi.michailo.entity.Message;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.repo.MessageRepo;
import ua.stryi.michailo.repo.MessegeListRepo;
import ua.stryi.michailo.service.MessegeListService;
import ua.stryi.michailo.service.MessegeService;
import ua.stryi.michailo.service.UserService;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Service
public class MessegeServiceImpl  implements MessegeService {
    @Autowired
    MessageRepo messageRepo;
    @Autowired
    UserService userService;
    @Autowired
    MessegeListRepo messegeListRepo;
    @Autowired
    MessegeListService messegeListService;



    @Override
    public List<Message> getMessage(Integer id) {
        User user1=userService.authenticationUser();
        User user2=userService.FindById(id);
        if (messegeListRepo.findByUserAndUserMesage(user1,user2).getMessageLists()!=null){
            System.out.println("return messegeListRepo");
            return messegeListRepo.findByUserAndUserMesage(user1,user2).getMessageLists();
        }
 return null;
    }

    @Override
    public Message addMessage(Message message, Integer id) {

        GregorianCalendar date=new GregorianCalendar();
        message.setDate(date);
        message.setName(userService.authenticationUser().getName());
        message.setSender(userService.authenticationUser());
        message.setRecipient(userService.FindById(id));
        messageRepo.save(message);
messegeListService.addMessageList(message,id);

//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        return message;
    }

    @Override
    public List<Message> newMessage(Integer user, Integer id) {
        User user1=userService.FindById(user);
        User user2=userService.authenticationUser();
        if (messageRepo.findBySenderAndRecipientNew(user1,user2,id)!=null){
            return messageRepo.findBySenderAndRecipientNew(user1,user2,id);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        if (messageRepo.findOne(id).getSender().getId()==userService.authenticationUser().getId()){
            messageRepo.delete(id);
        }else if (messageRepo.findOne(id).getRecipient().getId()==userService.authenticationUser().getId()){
            messageRepo.delete(id);
        }

    }
}
