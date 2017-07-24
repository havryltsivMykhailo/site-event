package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.stryi.michailo.entity.Message;
import ua.stryi.michailo.entity.MessageList;
import ua.stryi.michailo.repo.MessageRepo;
import ua.stryi.michailo.repo.UserRepo;
import ua.stryi.michailo.service.MessegeListService;
import ua.stryi.michailo.service.MessegeService;
import ua.stryi.michailo.service.UserService;

import java.util.List;

/**
 * Created by михайло on 16.05.2017.
 */
@Controller
public class MessageController {
    @Autowired
    MessageRepo messageRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    MessegeService messegeService;
    @Autowired
    UserService userService;
    @Autowired
    MessegeListService messegeListService;

    @RequestMapping(value = "/message/{id}",method = RequestMethod.GET)
    protected String getMessage(@PathVariable Integer id,Model model){
        model.addAttribute("user",userService.FindById(id));
        return "message";
    }


@RequestMapping(value = "/get/message/{id}",method = RequestMethod.GET)
@ResponseBody
    public List<Message> getMessageList(@PathVariable Integer id){
    return messegeService.getMessage(id);
    }
@RequestMapping(value = "/message/send/{id}")
@ResponseBody
    public Message addMessage(@PathVariable Integer id,@RequestBody Message message){

    return   messegeService.addMessage(message,id);
}
@RequestMapping(value = "/messages")
public String getMessageLists(){
        return "messages";
}

@RequestMapping(value = "/messages/list",method = RequestMethod.GET)
@ResponseBody
public List<MessageList> getMessageList(){
    return messegeListService.getMessageList();
}
@RequestMapping(value = "/get/message/{user}/new/{id}",method = RequestMethod.GET)
@ResponseBody
public List<Message> newMessage(@PathVariable Integer user,@PathVariable Integer id ){
    return   messegeService.newMessage(user,id);
}
@RequestMapping(value = "/message/delete",method = RequestMethod.POST)
@ResponseBody
public void delete(@RequestBody Integer id){
    messegeService.delete(id);
}

}
