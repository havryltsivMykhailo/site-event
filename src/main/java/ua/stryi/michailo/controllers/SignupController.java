package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.service.UserService;
import ua.stryi.michailo.validation.implementayion.UserBecend;

/**
 * Created by михайло on 14.05.2017.
 */
@Controller
@RequestMapping(value = "/registration")
public class SignupController {
    @Autowired
    UserBecend userBecend;
    @Autowired
    UserService userService;

    @RequestMapping( method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping( method = RequestMethod.POST)
    public String registration(@Validated User user, BindingResult bindingResult, @RequestParam("dates") String dates)  {
        userBecend.validate(user,bindingResult);
        if (bindingResult.hasErrors()){
            return "registration";
        }
        userService.add(user,dates);
        return "redirect:/";
    }


}


