package ua.stryi.michailo.service;

import ua.stryi.michailo.entity.Message;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface MessegeService {
    public List<Message> getMessage(Integer id);
    public Message addMessage(Message message,Integer id);
    public List<Message> newMessage(Integer user,Integer id);
    public void delete(Integer id);

}
