package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.stryi.michailo.entity.PerhapsParticipate;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.entity.UserEvent;
import ua.stryi.michailo.repo.PerhapsParticipateRepo;
import ua.stryi.michailo.service.PerharsParticipateService;
import ua.stryi.michailo.service.UserEventService;
import ua.stryi.michailo.service.UserService;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Service
public class PerharsParticipateServiceImpl implements PerharsParticipateService {
    @Autowired
    UserEventService userEventService;
    @Autowired
    UserService userService;
    @Autowired
    PerhapsParticipateRepo perhapsParticipateRepo;
    @Override
    public Integer participateUserEvent(Integer userEvent) {
        User user=userService.authenticationUser();
        UserEvent userEvent1=userEventService.findOne(userEvent);
        Integer a=getParticipateUserEventLength(userEvent);

        if (perhapsParticipateRepo.findByEventAndUser(userEvent1,user)==null){

            PerhapsParticipate perhapsParticipate=new PerhapsParticipate();
            perhapsParticipate.setUser(user);
            perhapsParticipate.setEvent(userEvent1);
            perhapsParticipateRepo.save(perhapsParticipate);
            ++a;
        }else {
            perhapsParticipateRepo.delete(perhapsParticipateRepo.findByEventAndUser(userEvent1,user));
            --a;
        }

        return a;
    }

    @Override
    public Integer getParticipateUserEventLength(Integer id) {
        return perhapsParticipateRepo.findByEvent(userEventService.findOne(id)).size();
    }

    @Override
    public List<PerhapsParticipate> getListLikeUserEvent(Integer id) {
        return perhapsParticipateRepo.findByEvent(userEventService.findOne(id));
    }
}
