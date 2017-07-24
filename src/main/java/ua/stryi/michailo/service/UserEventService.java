package ua.stryi.michailo.service;

import org.springframework.web.multipart.MultipartFile;
import ua.stryi.michailo.entity.UserEvent;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface UserEventService {
    public void add(UserEvent userEvent, MultipartFile multipartFile, String start,String ofCompletion );
    public void edit(UserEvent userEvent);
    public void delete(int id);
    public List<UserEvent> findAll();
    public List<UserEvent> findCategory(String category);
    public UserEvent findOne(Integer id);
    public  List<UserEvent> getEventDate(String date);
    public  List<UserEvent> getEventCategoryDate(String category,String date);
    public List<UserEvent> getMyEvent();
}
