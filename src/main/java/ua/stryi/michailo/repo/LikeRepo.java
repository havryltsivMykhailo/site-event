package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.stryi.michailo.entity.*;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface LikeRepo extends JpaRepository<Likes,Integer> {
    public Likes findByCommentAndAuthor(Comment comment, User author);
    public List<Likes> findByComment(Comment comment);
    public Likes findByEventAndAuthor(UserEvent userEvent,User user);
    public List<Likes> findByEvent(UserEvent userEvent);
    public List<Likes> findByArticle(Article article);
    public Likes findByArticleAndAuthor(Article article,User user);
    public List<Likes> findByPhotos(Photos photos);
    public Likes findByPhotosAndAuthor(Photos photos,User user);
}
