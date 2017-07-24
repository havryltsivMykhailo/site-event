package ua.stryi.michailo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.stryi.michailo.entity.Likes;
import ua.stryi.michailo.repo.LikeRepo;
import ua.stryi.michailo.service.CommentService;
import ua.stryi.michailo.service.LikeService;
import ua.stryi.michailo.service.UserService;

import java.util.List;

/**
 * Created by михайло on 11.06.2017.
 */
@Controller
public class LikeController {
    @Autowired
    UserService userService;
    @Autowired
    LikeRepo likeRepo;
    @Autowired
    CommentService commentService;
    @Autowired
    LikeService likeService;
    @RequestMapping(value = "/add/like/comment/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer addLikeComment(@PathVariable Integer id){

return likeService.addLikeComment(id);
    }
    @RequestMapping(value = "/get/like/comment/length/{id}")
    @ResponseBody
    public Integer getLikeCommentLength(@PathVariable Integer id){
       return likeService.getLikeCommentLength(id);
    }
    @RequestMapping(value = "/get/list/like/comment{id}")
    @ResponseBody
    public List<Likes> getListLikeComment(@PathVariable Integer id){
        return likeService.getListLikeComment(id);
    }
    @RequestMapping(value = "/like/userevent/Length/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer getLikeUserEventLength(@PathVariable Integer id){
        return likeService.getLikeUserEventLength(id);
    }
    @RequestMapping(value = "/like/userevent/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer likeUserEvent(@PathVariable Integer id){

        return likeService.likeUserEvent(id);
    }
    @RequestMapping(value = "/article/like/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer likeArticle(@PathVariable Integer id){
     return    likeService.likeArticle(id);
    }
    @RequestMapping(value = "/article/like/length/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer getLikeArticleLength(@PathVariable Integer id){
        return  likeService.getLikeArticletLength(id);
    }
    @RequestMapping(value = "/article/list/likes/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Likes> getListLikeArticle(@PathVariable Integer id){
        return likeService.getListLikeArticle(id);
    }

    @RequestMapping(value = "/photo/like/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer likePhoto(@PathVariable Integer id){
        return    likeService.likePhoto(id);
    }
    @RequestMapping(value = "/photo/like/length/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Integer getLikePhotoLength(@PathVariable Integer id){
        return  likeService.getLikePhotoLength(id);
    }
    @RequestMapping(value = "/photo/list/likes/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Likes> getListLikePhoto(@PathVariable Integer id){
        return likeService.getListLikePhoto(id);
    }
}
