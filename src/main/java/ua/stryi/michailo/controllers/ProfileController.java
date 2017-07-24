package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.service.UserService;

import java.util.List;

/**
 * Created by михайло on 18.05.2017.
 */
@Controller
public class ProfileController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String myProfile(Model model){
        model.addAttribute("user",userService.authenticationUser());
        return "myProfile";
    }
    @RequestMapping(value = "/profile/all",method = RequestMethod.GET)
    public String allProfile(Model model){
        List<User>userList=userService.FindAll();
        model.addAttribute("users",userList);
        return "allProfile";
    }
    @RequestMapping(value = "/profile/{id}" ,method = RequestMethod.GET)
    public String getProfile( @PathVariable Integer id,Model model){
        if (userService.authenticationUser().getId()==id){
            model.addAttribute("user",userService.authenticationUser());
            return "myProfile";
        }
        model.addAttribute("user",userService.FindById(id));
        return "profile";
    }

}
