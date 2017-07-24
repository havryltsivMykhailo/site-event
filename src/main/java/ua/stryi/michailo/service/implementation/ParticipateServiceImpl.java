package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.stryi.michailo.entity.Participate;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.entity.UserEvent;
import ua.stryi.michailo.repo.PatricipateRepo;
import ua.stryi.michailo.service.FriendService;
import ua.stryi.michailo.service.ParticipateService;
import ua.stryi.michailo.service.UserEventService;
import ua.stryi.michailo.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Service
public class ParticipateServiceImpl implements ParticipateService {
    @Autowired
    UserEventService userEventService;
    @Autowired
    UserService userService;
    @Autowired
    PatricipateRepo patricipateRepo;
    @Autowired
    FriendService friendService;
    @Override
    public Integer participateUserEvent(Integer userEvent) {
        User user=userService.authenticationUser();
        UserEvent userEvent1=userEventService.findOne(userEvent);
        Integer a=getParticipateUserEventLength(userEvent);

        if (patricipateRepo.findByEventAndUser(userEvent1,user)==null){

            Participate participate=new Participate();
            participate.setEvent(userEvent1);
            participate.setUser(user);
            patricipateRepo.save(participate);

            ++a;
        }else {
            patricipateRepo.delete(patricipateRepo.findByEventAndUser(userEvent1,user));
            --a;
        }

        return a;
    }

    @Override
    public Integer getParticipateUserEventLength(Integer id) {

        return patricipateRepo.findByEvent(userEventService.findOne(id)).size();
    }

    @Override
    public List<Participate> getListLikeUserEvent(Integer id) {
        return patricipateRepo.findByEvent(userEventService.findOne(id));
    }

    @Override
    public List<Participate> getListParticipate() {
        return patricipateRepo.findByUser(userService.authenticationUser());
    }

    @Override
    public List<Participate> myFriendsParticipate() {

        User user=userService.authenticationUser();
        List<User>userList=new ArrayList<>();
        if (friendService.all(user)!=null){
            userList.addAll(friendService.all(user));
        }
        List<Participate>participates=new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
          participates.addAll(patricipateRepo.findByUser(userList.get(i)));
        }


        return participates;
    }


}
