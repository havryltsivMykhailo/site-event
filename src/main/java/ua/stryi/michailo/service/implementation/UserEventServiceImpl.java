package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.stryi.michailo.entity.UserEvent;
import ua.stryi.michailo.repo.UserEventRepo;
import ua.stryi.michailo.service.UserEventService;
import ua.stryi.michailo.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Service
public class UserEventServiceImpl implements UserEventService {
    @Autowired
    UserService userService;
    @Autowired
    UserEventRepo userEventRepo;




    @Override
    public void add(UserEvent userEvent, MultipartFile multipartFile, String start, String ofCompletion ) {
        if (multipartFile!=null) {
            File file = new File("C:/Users/михайло/IdeaProjects/Event/src/main/webapp/resources/pictures/" + multipartFile.getOriginalFilename());
            file.mkdir();
            try {
                file.createNewFile();
                multipartFile.transferTo(file);
            } catch (IOException e) {

                e.printStackTrace();
            }
            userEvent.setPhoto("/resources/pictures/"+file.getName());
        }
        userEvent.setAuthor(userService.authenticationUser());
String []start1=start.split("-",3);
GregorianCalendar startDate=new GregorianCalendar(Integer.parseInt(start1[0]),Integer.parseInt(start1[1]),Integer.parseInt(start1[2]));
userEvent.setStartDate(startDate);
if (!ofCompletion.equalsIgnoreCase("")){

    String []b=ofCompletion.split("-",3);
    GregorianCalendar dateOfCompletion=new GregorianCalendar(Integer.parseInt(b[0]),Integer.parseInt(b[1]),Integer.parseInt(b[2]));
    userEvent.setDateOfCompletion(dateOfCompletion);
}
userEventRepo.save(userEvent);
    }

    @Override
    public void edit(UserEvent userEvent) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<UserEvent> findAll() {
        List<UserEvent> userEventList=new ArrayList<>();
        if (userEventRepo.findAll()!=null) {
            userEventList.addAll(userEventRepo.findAll());
        }

        userEventList.sort(new Comparator<UserEvent>() {
            @Override
            public int compare(UserEvent o1, UserEvent o2) {
                int a=0;
                if (o1.getStartDate().getTime().getTime()>o2.getStartDate().getTime().getTime()){
                    a= 1;
                }else if (o1.getStartDate().getTime().getTime()<o2.getStartDate().getTime().getTime()){
                    a= -1;}
                return a;
            }


        });
        return userEventList;
    }

    @Override
    public List<UserEvent> findCategory(String category) {
        List<UserEvent> userEventList=new ArrayList<>();
        if (userEventRepo.findByCategory(category)!=null) {
            userEventList.addAll(userEventRepo.findByCategory(category));
        }
        userEventList.sort(new Comparator<UserEvent>() {
            @Override
            public int compare(UserEvent o1, UserEvent o2) {
                int a=0;
                if (o1.getStartDate().getTime().getTime()>o2.getStartDate().getTime().getTime()){
                    a= 1;
                }else if (o1.getStartDate().getTime().getTime()<o2.getStartDate().getTime().getTime()){
                    a= -1;}
                return a;
            }


        });
        return userEventList;
    }


    @Override
    public UserEvent findOne(Integer id) {
        return userEventRepo.findOne(id);
    }

    @Override
    public List<UserEvent> getEventDate(String date) {

        String []date1=date.split("-",3);
        GregorianCalendar startDate=new GregorianCalendar(Integer.parseInt(date1[0]),Integer.parseInt(date1[1]),Integer.parseInt(date1[2]));




        return userEventRepo.findByStartDate(startDate);
    }

    @Override
    public List<UserEvent> getEventCategoryDate(String category, String date) {
        String []date1=date.split("-",3);
        GregorianCalendar startDate=new GregorianCalendar(Integer.parseInt(date1[0]),Integer.parseInt(date1[1]),Integer.parseInt(date1[2]));

        return userEventRepo.findByCategoryAndDate(category,startDate);
    }

    @Override
    public List<UserEvent> getMyEvent() {

        return userEventRepo.findByAuthor(userService.authenticationUser());
    }
}
