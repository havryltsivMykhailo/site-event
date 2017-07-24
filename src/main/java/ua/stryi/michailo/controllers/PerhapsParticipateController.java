package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.stryi.michailo.entity.PerhapsParticipate;
import ua.stryi.michailo.service.PerharsParticipateService;

import java.util.List;

/**
 * Created by михайло on 15.06.2017.
 */
@Controller
public class PerhapsParticipateController {
@Autowired
PerharsParticipateService service;

    @RequestMapping(value = "/perhaps/participate/userevent/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer perhapsParticipateUserEvent(@PathVariable Integer id){
        return service.participateUserEvent(id);
    }
    @RequestMapping(value = "/perhaps/participate/userevent/Length/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer getPerhapsParticipateUserEventLength(@PathVariable Integer id){
        return service.getParticipateUserEventLength(id);
    }
    @RequestMapping(value = "/perhaps/participate/userevent/list/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<PerhapsParticipate> getList(@PathVariable Integer id){
        return service.getListLikeUserEvent(id);
    }
}
