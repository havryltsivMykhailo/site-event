package ua.stryi.michailo.service;

import ua.stryi.michailo.entity.Comment;
import ua.stryi.michailo.entity.Likes;
import ua.stryi.michailo.entity.User;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface LikeService {
    public Integer addLikeComment(Integer id);
    public void deleteLikeComment(Comment comment, User user);
    public Integer getLikeCommentLength(Integer id);
    public List<Likes> getListLikeComment(Integer id);

    public Integer likeUserEvent(Integer userEvent);
    public Integer getLikeUserEventLength(Integer id);
    public List<Likes> getListLikeUserEvent(Integer id);

    public Integer likeArticle(Integer id);
    public Integer getLikeArticletLength(Integer id);
    public List<Likes> getListLikeArticle(Integer id);

    public Integer likePhoto(Integer id);
    public Integer getLikePhotoLength(Integer id);
    public List<Likes> getListLikePhoto(Integer id);




}
