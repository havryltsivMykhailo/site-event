package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.stryi.michailo.entity.Comment;
import ua.stryi.michailo.entity.Photos;
import ua.stryi.michailo.entity.UserEvent;
import ua.stryi.michailo.repo.CommentRepo;
import ua.stryi.michailo.repo.UserEventRepo;
import ua.stryi.michailo.service.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    PhotosService photosService;
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    UserService userService;
    @Autowired
    UserEventRepo userEventRepo;
    @Autowired
    UserEventService userEventService;
    @Autowired
    ArticleService articleService;
    @Override
    public List<Comment> getPhotoComment(Integer id) {
        Photos photos=photosService.picture(id);
        return commentRepo.findByPhotos(photos);
    }

    @Override
    public void addPhotoComment(Integer id,Comment comment) {
        comment.setAuthor(userService.authenticationUser());
        Photos photos=photosService.picture(id);
        comment.setPhotos(photos);
        GregorianCalendar gregorianCalendar=new GregorianCalendar();
        comment.setDate(gregorianCalendar);
        commentRepo.save(comment);

    }

    @Override
    public void deletePhotoComment(Integer id) {
        commentRepo.delete(id);
    }

    @Override
    public void addUserEventComment(Integer id, Comment comment) {
        System.out.println(1);
        comment.setAuthor(userService.authenticationUser());
        System.out.println(2);
        comment.setUserEvent(userEventRepo.findOne(id));
        System.out.println(3);
        GregorianCalendar gregorianCalendar=new GregorianCalendar();
        System.out.println(4);
        comment.setDate(gregorianCalendar);
        System.out.println(5);
        commentRepo.save(comment);
        System.out.println(6);
    }

    @Override
    public List<Comment> getUserEventComment(Integer id) {

        UserEvent userEvent=userEventRepo.findOne(id);


        List<Comment> commentList=new ArrayList<>();

        if (commentRepo.findByUserEvent(userEvent)!=null){

            commentList.addAll(commentRepo.findByUserEvent(userEvent));


        }
        return commentList;
    }

    @Override
    public List<Comment> newUserEventComment(Integer userEvent, Integer id) {


        return commentRepo.findCommentComet(userEventService.findOne(userEvent),id);
    }

    @Override
    public Comment FindById(Integer id) {
        return commentRepo.findOne(id);
    }

    @Override
    public void addArticleComment(Comment comment, Integer id) {
        comment.setAuthor(userService.authenticationUser());
        comment.setArticle(articleService.FindById(id));
        comment.setDate(new GregorianCalendar());
        commentRepo.save(comment);

    }

    @Override
    public void deleteArticleComment(Integer id) {
     if (commentRepo.findOne(id).getAuthor().getId()==userService.authenticationUser().getId()){
         commentRepo.delete(id);
     }else if (commentRepo.findOne(id).getArticle().getUser().getId()==userService.authenticationUser().getId()){
         commentRepo.delete(id);
     }

    }

    @Override
    public List<Comment> getAllArticleComment(Integer id) {
        return commentRepo.findByArticle(articleService.FindById(id));
    }

    @Override
    public Integer commentLengthArticle(Integer id) {
        return getAllArticleComment(id).size();
    }

    @Override
    public void deleteEventComment(Integer id) {
        commentRepo.delete(id);
    }
}

