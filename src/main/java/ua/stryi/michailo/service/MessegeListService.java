package ua.stryi.michailo.service;

import ua.stryi.michailo.entity.Message;
import ua.stryi.michailo.entity.MessageList;

import java.util.List;

/**
 * Created by михайло on 18.05.2017.
 */
public interface MessegeListService {


    public List<MessageList> getMessageList();
    public void addMessageList(Message message,Integer id);
}
