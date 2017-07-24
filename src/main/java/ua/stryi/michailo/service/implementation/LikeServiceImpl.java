package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.stryi.michailo.entity.*;
import ua.stryi.michailo.repo.LikeRepo;
import ua.stryi.michailo.service.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Service
public class LikeServiceImpl  implements LikeService {
    @Autowired
    LikeRepo likeRepo;
    @Autowired
    CommentService commentService;
    @Autowired
    UserEventService userEventService;
    @Autowired
    UserService userService;
    @Autowired
    PhotosService photosService;
    @Autowired
    ArticleService articleService;
    @Autowired
    RepostService repostService;

    @Override
    public Integer addLikeComment(Integer id) {
        User user=userService.authenticationUser();
        Comment comment=commentService.FindById(id);
        Integer a=getLikeCommentLength(id);
        if (likeRepo.findByCommentAndAuthor(comment,user)==null){
            ++a;
            Likes likes = new Likes();
            likes.setDate(new GregorianCalendar());
            likes.setAuthor(user);
            likes.setComment(comment);
            likeRepo.save(likes);


        }else {
            deleteLikeComment(comment,user);
            --a;
        }




return a;

    }

    @Override
    public void deleteLikeComment(Comment comment, User user) {
        likeRepo.delete(likeRepo.findByCommentAndAuthor(comment, user));
    }

    @Override
    public Integer getLikeCommentLength(Integer id) {
        List<Likes> likesList = new ArrayList<>();
        likesList.addAll(likeRepo.findByComment(commentService.FindById(id)));
        return likesList.size();
    }

    @Override
    public List<Likes> getListLikeComment(Integer id) {
        return likeRepo.findByComment(commentService.FindById(id));
    }

    @Override
    public Integer likeUserEvent(Integer userEvent) {

        UserEvent userEvent1 = userEventService.findOne(userEvent);
        User user1 = userService.authenticationUser();
        int a = getLikeUserEventLength(userEvent);

        if (likeRepo.findByEventAndAuthor(userEvent1, user1) == null) {
            Likes likes = new Likes();
            likes.setAuthor(user1);
            likes.setEvent(userEvent1);
            likeRepo.save(likes);
            ++a;
        } else {
            likeRepo.delete(likeRepo.findByEventAndAuthor(userEvent1, user1));
            --a;
        }


        return a;
    }

    @Override
    public Integer getLikeUserEventLength(Integer id) {
        return likeRepo.findByEvent(userEventService.findOne(id)).size();
    }

    @Override
    public List<Likes> getListLikeUserEvent(Integer id) {
        return likeRepo.findByEvent(userEventService.findOne(id));
    }

    @Override
    public Integer likeArticle(Integer id) {
        Article article = articleService.FindById(id);
        User user = userService.authenticationUser();
        Integer a = getLikeArticletLength(id);
        if (likeRepo.findByArticleAndAuthor(article, user) == null) {
            Likes likes = new Likes();
            likes.setDate(new GregorianCalendar());
            likes.setAuthor(user);
            likes.setArticle(article);
            likeRepo.save(likes);
            ++a;
        } else {
            likeRepo.delete(likeRepo.findByArticleAndAuthor(article, user));
            --a;
        }
        return a;
    }

    @Override
    public Integer getLikeArticletLength(Integer id) {
        return likeRepo.findByArticle(articleService.FindById(id)).size();
    }

    @Override
    public List<Likes> getListLikeArticle(Integer id) {
        return likeRepo.findByArticle(articleService.FindById(id));
    }

    @Override
    public Integer likePhoto(Integer id) {
        Photos photos = photosService.picture(id);
        User user = userService.FindById(id);
        Integer a = getLikePhotoLength(id);
        if (likeRepo.findByPhotosAndAuthor(photos, user) == null) {
            Likes likes = new Likes();
            likes.setAuthor(user);
            likes.setDate(new GregorianCalendar());
            likes.setPhotos(photos);
            likeRepo.save(likes);
            ++a;
        } else {
            likeRepo.delete(likeRepo.findByPhotosAndAuthor(photos, user));
            --a;
        }

        return a;
    }

    @Override
    public Integer getLikePhotoLength(Integer id) {
        return likeRepo.findByPhotos(photosService.picture(id)).size();
    }

    @Override
    public List<Likes> getListLikePhoto(Integer id) {

        return likeRepo.findByPhotos(photosService.picture(id));
    }
}


