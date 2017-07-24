package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.stryi.michailo.entity.UserEvent;
import ua.stryi.michailo.service.UserEventService;

import java.util.List;

/**
 * Created by михайло on 09.05.2017.
 */
@Controller
public class EventController {
    @Autowired
    UserEventService userEventService;

    @RequestMapping(value = "/event/add",method = RequestMethod.GET)
    public String addEvent(Model model){
model.addAttribute("userEvents",new UserEvent());
        return "addEvent";
    }
@RequestMapping(value = "/event/add",method = RequestMethod.POST)
public String addEvent(@ModelAttribute UserEvent userEvent,@RequestParam("mediaFile") MultipartFile multipartFile, @RequestParam("start") String start,@RequestParam("ofCompletion") String ofCompletion){
    userEventService.add(userEvent,multipartFile,start,ofCompletion);
    return "redirect:/";
}
@RequestMapping(value = "/{category}",method = RequestMethod.GET)
public String getCategoryUserEvent(Model model,@PathVariable String category){
    model.addAttribute("category",category);
    return "categoryEvent";
}
@RequestMapping(value = "/get/user/event/{category}",method = RequestMethod.GET)
@ResponseBody
public List<UserEvent> getFindCategoryList(@PathVariable String category){
    return userEventService.findCategory(category);
}
@RequestMapping(value = "/get/user/event",method = RequestMethod.GET)
@ResponseBody
public List<UserEvent> getAllEvent(){
    return userEventService.findAll();
}
@RequestMapping(value = "/event/find/{id}",method = RequestMethod.GET)
@ResponseBody
public UserEvent getEvent(@PathVariable Integer id){
  return   userEventService.findOne(id);
}
@RequestMapping(value = "/event/sort/date",method = RequestMethod.POST)
@ResponseBody
public List<UserEvent> getEventDate(@RequestBody String date){

    return userEventService.getEventDate(date );

}
    @RequestMapping(value = "/get/user/event/{category}",method = RequestMethod.POST)
    @ResponseBody
    public List<UserEvent> getEventCategoryDate(@PathVariable String category,@RequestBody String date){
        return userEventService.getEventCategoryDate(category,date );

    }
    @RequestMapping(value = "/profile/events",method = RequestMethod.GET)
    public String myEvents(Model model){
        model.addAttribute("events",userEventService.getMyEvent());
        return "UserEvents";
    }
@RequestMapping(value = "/event/{id}",method = RequestMethod.GET)
public String findBYEvent(@PathVariable Integer id,Model model){
        model.addAttribute("event",id);
        return "findByEvent";

}


}
