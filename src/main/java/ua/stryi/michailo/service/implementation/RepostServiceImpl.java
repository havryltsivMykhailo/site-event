package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.stryi.michailo.entity.Article;
import ua.stryi.michailo.entity.Repost;
import ua.stryi.michailo.repo.RepostRepo;
import ua.stryi.michailo.service.RepostService;
import ua.stryi.michailo.service.UserEventService;
import ua.stryi.michailo.service.UserService;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Service
public class RepostServiceImpl implements RepostService{
@Autowired
    UserService userService;
@Autowired
    UserEventService userEventService;
@Autowired
RepostRepo repostRepo;

    @Override
    public void add(Article article, Integer id) {
        Repost repost=new Repost();
        repost.setDate(new GregorianCalendar());
        repost.setUser(userService.authenticationUser());
        repost.setEvent(userEventService.findOne(id));
        article.setAuthor(repost.getUser());
        article.setUser(repost.getUser());
        article.setDate(repost.getDate());
        repost.setArticle(article);
        repostRepo.save(repost);

    }

    @Override
    public void delete(Integer id) {
if (repostRepo.findOne(id).getUser().getId()==userService.authenticationUser().getId()){
    repostRepo.delete(repostRepo.findOne(id));
}
    }

    @Override
    public List<Repost> getAll(Integer id) {
        return repostRepo.findByUser(userService.FindById(id));
    }

    @Override
    public Repost findById(Integer id) {
        return repostRepo.findOne(id);
    }
}
