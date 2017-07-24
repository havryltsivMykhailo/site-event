package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.stryi.michailo.entity.Article;
import ua.stryi.michailo.entity.User;

import java.util.List;

/**
 * Created by михайло on 19.06.2017.
 */
public interface ArticleRepo extends JpaRepository<Article,Integer> {
    public List<Article> findByUser(User user);
    public List<Article> findByAuthor(User user);
}
