package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.stryi.michailo.service.FollowersService;
import ua.stryi.michailo.service.UserService;

/**
 * Created by михайло on 18.05.2017.
 */
@Controller
public class FollowersController {
@Autowired
    FollowersService followersService;
@Autowired
UserService userService;
@RequestMapping(value = "/profile/{id}/add/followers",method = RequestMethod.GET)
    public String addFollowers(@PathVariable Integer id){
        followersService.add(id);
        return "redirect:/profile/"+id;
    }
    @RequestMapping(value = "/profile/followers",method = RequestMethod.GET)
    public String getMyFollowers(Model model){
    model.addAttribute("followerss",followersService.findByAllFollowers(userService.authenticationUser()));
        return "followers";
    }
    @RequestMapping(value = "/profile/followers/delete/{id}",method = RequestMethod.GET)
    public String deleteFolowers(@PathVariable Integer id){
        followersService.delete(id);
        return "redirect:/profile/"+id;
    }
    @RequestMapping(value = "/profile/following/cancel/{id}",method = RequestMethod.GET)
    public String cancelFollowing(@PathVariable Integer id){
        followersService.cancelFollowing(id);
        return "redirect:/profile/"+id;
    }
    @RequestMapping(value = "/profile/followers/{id}",method = RequestMethod.GET)
    public String getFollowers(Model model,@PathVariable Integer id){
        model.addAttribute("followerss",followersService.findByAllFollowers(userService.FindById(id)));
        return "followers";
    }
}
