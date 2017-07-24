package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.repo.UserRepo;
import ua.stryi.michailo.service.UserService;

import java.text.SimpleDateFormat;

/**
 * Created by михайло on 14.05.2017.
 */
@Controller
@RequestMapping(value = "/account/edit")
public class UserEditController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public String editAccount( Model model){
        User user=userService.authenticationUser();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
String date=simpleDateFormat.format(user.getAge().getTime()).toString();
        model.addAttribute("user",user);
        model.addAttribute("date",date);
        return "accountEdit";
    }
}
