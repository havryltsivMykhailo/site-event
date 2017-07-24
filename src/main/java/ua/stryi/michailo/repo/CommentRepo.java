package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.stryi.michailo.entity.Article;
import ua.stryi.michailo.entity.Comment;
import ua.stryi.michailo.entity.Photos;
import ua.stryi.michailo.entity.UserEvent;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface CommentRepo extends JpaRepository<Comment,Integer>{
    public List<Comment> findByPhotos(Photos photos);
    public List<Comment> findByUserEvent(UserEvent userEvent);
    public List<Comment> findByArticle(Article article);


    @Query("SELECT u FROM Comment u WHERE u.userEvent=:userEvent and u.id>:id")
    public List<Comment> findCommentComet(@Param("userEvent") UserEvent userEvent,@Param("id") Integer id);
}
