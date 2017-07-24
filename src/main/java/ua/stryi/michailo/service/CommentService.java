package ua.stryi.michailo.service;

import ua.stryi.michailo.entity.Comment;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface CommentService {
    public List<Comment> getPhotoComment(Integer id);
   public void addPhotoComment(Integer id, Comment comment);
   public void deletePhotoComment(Integer id);
    public void addUserEventComment(Integer id,Comment comment);
    public List<Comment> getUserEventComment(Integer id);
public List<Comment> newUserEventComment(Integer userEvent,Integer id);
    public Comment FindById(Integer id);
public void addArticleComment(Comment comment,Integer id);
public void deleteArticleComment(Integer id);
public List<Comment> getAllArticleComment(Integer id);
public Integer commentLengthArticle(Integer id);
public void deleteEventComment (Integer id);
}
