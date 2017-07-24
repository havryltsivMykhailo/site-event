package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.service.FriendService;
import ua.stryi.michailo.service.UserService;

import java.util.List;

/**
 * Created by михайло on 18.05.2017.
 */
@Controller
public class FriendController {
    @Autowired
    FriendService friendService;
    @Autowired
    UserService userServiceIml;
    @RequestMapping(value = "/profile/add/friend/{id}",method = RequestMethod.GET)
    public String addFriend(@PathVariable Integer id){
        friendService.add(id);
        return "redirect:/profile";
    }
    @RequestMapping(value = "/profile/{id}/friends", method = RequestMethod.GET)
public String userAllFriend(@PathVariable Integer id, Model model){
model.addAttribute("friends",friendService.all(userServiceIml.FindById(id)));

        return "friend";
}
@RequestMapping(value = "/friends",method = RequestMethod.GET)
public String allFriends(Model model){
  model.addAttribute("friends",friendService.all(userServiceIml.authenticationUser()));
    return "myFriend";
}
    @RequestMapping(value = "/friend/delete/{id}",method = RequestMethod.GET)
public String friendDelete(@PathVariable Integer id){
    friendService.delete(id);
    return "redirect:/friends";
}
@RequestMapping(value = "profile/checking/friend/{id}",method = RequestMethod.GET)
@ResponseBody
public Integer сheckingForFriendship(@PathVariable Integer id){
    return friendService.сheckingForFriendship(id);
}
@RequestMapping(value = "/find/by/users",method = RequestMethod.POST)
@ResponseBody
public List<User> findByUser(@RequestBody String a){
    return userServiceIml.findByUser(a);
}
@RequestMapping(value = "/search/new/user",method = RequestMethod.GET)
public  String search(){
    return "search";
}
}
