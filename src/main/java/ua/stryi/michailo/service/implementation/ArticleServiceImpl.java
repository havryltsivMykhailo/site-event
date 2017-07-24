package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.stryi.michailo.entity.Article;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.repo.ArticleRepo;
import ua.stryi.michailo.service.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 19.06.2017.
 */
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    ArticleRepo articleRepo;
    @Autowired
    UserService userService;
@Autowired
    RepostService repostService;
@Autowired
FriendService friendService;
@Autowired
FollowersService followersService;

    @Override
    public void addArticle(String post, MultipartFile multipartFile, Integer id) {
        Article article=new Article();
        article.setDescription(post);
        article.setDate(new GregorianCalendar());
        article.setUser(userService.FindById(id));
        article.setAuthor(userService.authenticationUser());
        if (!multipartFile.isEmpty()){
            File file = new File("C:/Users/михайло/IdeaProjects/Event/src/main/webapp/resources/pictures/"+id+"/" );
            file.mkdir();
            File file1 =new File(file,multipartFile.getOriginalFilename());
            try {
                file1.createNewFile();
                multipartFile.transferTo(file1);
            } catch (IOException e) {

                e.printStackTrace();
            }
            article.setPhotoUrl("/resources/pictures/"+id+"/"+file1.getName());

        }
        articleRepo.save(article);
    }

    @Override
    public void addMyArticle(String post, MultipartFile multipartFile) {
        Integer id=userService.authenticationUser().getId();
        Article article=new Article();
        article.setDate(new GregorianCalendar());
        article.setUser(userService.authenticationUser());
        article.setAuthor(userService.authenticationUser());
        if (!multipartFile.isEmpty()){
            File file = new File("C:/Users/михайло/IdeaProjects/Event/src/main/webapp/resources/pictures/"+id+"/" );
            file.mkdir();
            File file1 =new File(file,multipartFile.getOriginalFilename());
            try {
                file1.createNewFile();
                multipartFile.transferTo(file1);
            } catch (IOException e) {
                System.out.println("помилка");
                e.printStackTrace();
            }
            article.setPhotoUrl("/resources/pictures/"+id+"/"+file1.getName());

        }

        articleRepo.save(article);
    }

    @Override
    public void edit(Article article) {
       articleRepo.save(article);

    }

    @Override
    public void delete(Integer id) {
        if (articleRepo.findOne(id).getAuthor().getId()==userService.authenticationUser().getId()){
//            if (articleRepo.findOne(id).getRepost()!=null){
//                repostService.delete(articleRepo.findOne(id).getRepost().getId());
//            }
            articleRepo.delete(id);
        }


    }

    @Override
    public void deleteArticleRepost(Integer id) {
        if (articleRepo.findOne(id).getAuthor().getId()==userService.authenticationUser().getId()){
            repostService.delete(articleRepo.findOne(id).getRepost().getId());
            articleRepo.delete(id);
        }else if (articleRepo.findOne(id).getUser().getId()==userService.authenticationUser().getId()){
            repostService.delete(articleRepo.findOne(id).getRepost().getId());
            articleRepo.delete(id);
        }
    }

    @Override
    public Article FindById(Integer id) {
        return articleRepo.findOne(id);
    }

    @Override
    public List<Article> findAll() {
        return articleRepo.findByUser(userService.authenticationUser());
    }

    @Override
    public List<Article> findAll(Integer id) {
        return articleRepo.findByUser(userService.FindById(id));
    }

    @Override
    public void sava(Article article) {
        articleRepo.save(article);
    }

    @Override
    public List<Article> news() {
        User user=userService.authenticationUser();
        List<User> userList=new ArrayList<>();
        if (friendService.all(user)!=null){
            userList.addAll(friendService.all(user));
        }
        if (followersService.findByAllFollowing(user)!=null){
            userList.addAll(followersService.findByAllFollowing(user));
        }
        List<Article>articles=new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            if (articleRepo.findByAuthor(userList.get(i))!=null){
                articles.addAll(articleRepo.findByAuthor(userList.get(i)));
            }
        }



        return articles;
    }


}
