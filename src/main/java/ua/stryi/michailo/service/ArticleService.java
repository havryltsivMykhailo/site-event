package ua.stryi.michailo.service;

import org.springframework.web.multipart.MultipartFile;
import ua.stryi.michailo.entity.Article;

import java.util.List;

/**
 * Created by михайло on 19.06.2017.
 */
public interface ArticleService {
    void addArticle(String post, MultipartFile multipartFile, Integer id);
    void addMyArticle(String post, MultipartFile multipartFile);
    void edit(Article article);
    void delete(Integer id);
    void deleteArticleRepost(Integer id);
    Article FindById(Integer id);
    List<Article>findAll();
    List<Article>findAll(Integer id);
    public void sava(Article article);
    List<Article> news();
}
