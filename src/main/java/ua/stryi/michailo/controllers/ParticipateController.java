package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.stryi.michailo.entity.Participate;
import ua.stryi.michailo.service.ParticipateService;

import java.util.List;

/**
 * Created by михайло on 14.06.2017.
 */
@Controller
public class ParticipateController {
 @Autowired
    ParticipateService participateService;
@RequestMapping(value = "/participate/userevent/{id}",method = RequestMethod.GET)
@ResponseBody
    public Integer participateUserEvent(@PathVariable Integer id){
        return participateService.participateUserEvent(id);
    }
    @RequestMapping(value = "/participate/userevent/Length/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer getParticipateUserEventLength(@PathVariable Integer id){
        return participateService.getParticipateUserEventLength(id);
    }
    @RequestMapping(value = "/participate/userevent/list/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Participate> getListParticipate(@PathVariable Integer id){
        return participateService.getListLikeUserEvent(id);
    }
    @RequestMapping(value = "/profile/events/take/part",method = RequestMethod.GET)
    public String myEventsParticipate(Model model){
        model.addAttribute("events",participateService.getListParticipate());
        return "takePart";
    }
    @RequestMapping(value = "/profile/events/involving/friends",method = RequestMethod.GET)
    public String myFriendsParticipate(Model model){
        model.addAttribute("events",participateService.myFriendsParticipate());
        return "friendsParticipate";
    }

}
