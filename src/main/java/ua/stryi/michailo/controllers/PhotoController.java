package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import ua.stryi.michailo.entity.Photos;
import ua.stryi.michailo.service.PhotosService;
import ua.stryi.michailo.service.UserService;

import java.util.List;

/**
 * Created by михайло on 16.05.2017.
 */
@Controller
public class PhotoController {
    @Autowired
    PhotosService photosService;
    @Autowired
    UserService userService;

    @RequestMapping(value ="/profile/add/picture" ,method = RequestMethod.POST)
    public String addPictures(@RequestParam("mediaFile") MultipartFile multipartFile) {

          photosService.addPictures(multipartFile);
          return "redirect:/profile/";






    }
    @RequestMapping(value = "/profile/add/avatar",method = RequestMethod.POST)
    public String addAvatarPicture(@RequestParam("mediaFile") MultipartFile multipartFile)throws MaxUploadSizeExceededException {
        try  { photosService.addAvatarPicture(multipartFile);
            return "redirect:/profile/";}
        catch (MaxUploadSizeExceededException e) {
            System.out.println("помилка");
            return "redirect:/profile/";
        }




    }
@RequestMapping(value = "/profile/picture/{id}/avatar",method = RequestMethod.GET)
    public String chooseAvatar(@PathVariable Integer id){
        photosService.chooseAvatar(id);
        return "redirect:/profile";
    }
    @RequestMapping(value = "/profile/picture/delete/{id}")
public String deletePicture(@PathVariable Integer id){
        photosService.deletePicture(id);
        return "redirect:/profile/pictures";
    }
@RequestMapping(value = "/profile/{id}/pictures",method =  RequestMethod.GET)
    public String allPicture(Model model,@PathVariable Integer id){
        List<Photos> photosList=photosService.allPicture(id);
        model.addAttribute("pictures",photosList);
return "pictures";
    }
    @RequestMapping(value = "/profile/pictures",method =  RequestMethod.GET)
    public String allMyPicture(Model model){
        List<Photos> photosList=photosService.allMyPicture();
        model.addAttribute("pictures",photosList);
return "myPictures";
    }
    @RequestMapping(value = "/profile/picture/{id}",method =  RequestMethod.GET)
    public String picture(Model model,@PathVariable Integer id){
        model.addAttribute("picture",photosService.picture(id));
        return "picture";
    }
    @RequestMapping(value = "/profile/сhecking/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer сheckingUser(@PathVariable Integer id){
        return photosService.сheckingUser(id);
    }

}
