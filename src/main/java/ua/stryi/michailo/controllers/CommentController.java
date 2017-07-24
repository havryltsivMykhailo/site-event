package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.stryi.michailo.entity.Comment;
import ua.stryi.michailo.service.CommentService;

import java.util.List;

/**
 * Created by михайло on 18.05.2017.
 */
@Controller
public class CommentController  {
@Autowired
    CommentService commentService ;
@RequestMapping(value = "/profile/picture/comment/{id}",method = RequestMethod.GET)
@ResponseBody
    public List<Comment> getPictureComment(@PathVariable Integer id){
return commentService.getPhotoComment(id);
    }
    @RequestMapping(value = "/profile/picture/add/comment/{id}",method = RequestMethod.POST)
    @ResponseBody
    public void addPhotoComment(@PathVariable Integer id,@RequestBody Comment comment){
        commentService.addPhotoComment(id,comment);
    }
    @RequestMapping(value = "/user/event/add/comment/{id}",method = RequestMethod.POST)
    @ResponseBody
    public void addUserEventComment(@PathVariable Integer id,@RequestBody Comment comment){
        commentService.addUserEventComment(id,comment);
    }
    @RequestMapping(value = "/profile/picture//delete/comment/{f}",method = RequestMethod.GET)
    public void deletePhotoComment(@PathVariable Integer f){
        commentService.deletePhotoComment(f);
    }
    @RequestMapping(value = "/useruvent/get/comments/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getUserEventComment(@PathVariable Integer id){
        return commentService.getUserEventComment(id);
    }

    @RequestMapping(value = "/useruvent/get/comments/{r}/onl/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Comment> getNewUserEventComment(@PathVariable Integer r,@PathVariable Integer id){
        if (commentService.newUserEventComment(r,id)!=null){

return commentService.newUserEventComment(r,id);
            }
        return null;
    }
    @RequestMapping(value = "/event/comment/delete/{id}",method = RequestMethod.GET)
    public String deleteEventComment(@PathVariable Integer id){
        commentService.deleteEventComment(id);
        return "redirect:/";
    }
    @RequestMapping(value = "/article/add/comment/{id}",method = RequestMethod.POST)
    @ResponseBody
public void addArticleComment(@RequestBody Comment comment,@PathVariable Integer id){
        commentService.addArticleComment(comment,id);
}
    @RequestMapping(value = "/article/comment/delete/{id}",method = RequestMethod.GET)
public String deleteArticleComment(@PathVariable Integer id){
    commentService.deleteArticleComment(id);
        return "redirect:/profile";
}
    @RequestMapping(value = "/article/get/comments/{id}",method = RequestMethod.GET)
    @ResponseBody
public List<Comment> findAllArticleComment(@PathVariable Integer id){
        for (int i = 0; i < commentService.getAllArticleComment(id).size(); i++) {
            System.out.println( commentService.getAllArticleComment(id).get(i).getComment());
        }
    return commentService.getAllArticleComment(id);
}

    @RequestMapping(value = "/article/get/comments/length/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer commentLengthArticle(@PathVariable Integer id){
        return commentService.commentLengthArticle(id);
    }

}
