package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.stryi.michailo.service.UserService;

/**
 * Created by михайло on 08.05.2017.
 */
@Controller
public class BaseController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

@RequestMapping(value = "/registration/activation/{activator}",method = RequestMethod.GET)
public String activation(@PathVariable String activator){
    userService.activ(activator);
    return "redirect:/";
}



}
