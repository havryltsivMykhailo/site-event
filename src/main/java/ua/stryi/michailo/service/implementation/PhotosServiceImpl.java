package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.stryi.michailo.entity.Article;
import ua.stryi.michailo.entity.Photos;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.repo.PhotosRepo;
import ua.stryi.michailo.repo.UserRepo;
import ua.stryi.michailo.service.ArticleService;
import ua.stryi.michailo.service.PhotosService;
import ua.stryi.michailo.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Service
public class PhotosServiceImpl implements PhotosService {
    @Autowired
    UserService userService;
    @Autowired
    UserRepo userRepo;
    @Autowired
    PhotosRepo photosRepo;
@Autowired
ArticleService articleService;
    @Override
    public void addPictures(MultipartFile multipartFile) {
        String userName=userService.authenticationUserName();
        File file=new File("C:/Users/михайло/IdeaProjects/Event/src/main/webapp/resources/pictures/"+userName+"/");
        file.mkdir();
        File file1 =new File(file,multipartFile.getOriginalFilename());
        try {
            file1.createNewFile();
            multipartFile.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GregorianCalendar date=new GregorianCalendar();

        String url="/resources/pictures/"+userName+"/"+multipartFile.getOriginalFilename();
        Photos photos=new Photos(url,date);
        User user=userService.authenticationUser();
        photos.setUser(user);
        Article article=new Article();
        article.setPhotos(photos);
        article.setDate(photos.getDate());
        article.setUser(photos.getUser());
        article.setAuthor(photos.getUser());

photosRepo.save(photos);
        articleService.sava(article);

    }

    @Override
    public void addAvatarPicture(MultipartFile multipartFile) {
        String userName=userService.authenticationUserName();
        User user=userService.authenticationUser();
        File file=new File("C:/Users/михайло/IdeaProjects/Event/src/main/webapp/resources/pictures/"+userName+"/");
        file.mkdir();
        File file1 =new File(file,multipartFile.getOriginalFilename());

        try {
            file1.createNewFile();
            multipartFile.transferTo(file1);
        } catch (IOException e) {
            System.out.println("помилка");
            e.printStackTrace();
        }
        GregorianCalendar date=new GregorianCalendar();
        String url="/resources/pictures/"+userName+"/"+multipartFile.getOriginalFilename();
        Photos photos=new Photos(url,date);
        user.setAvatar(url);
        photos.setUser(user);
        photosRepo.save(photos);
        userService.edit(user);

    }

    @Override
    public void chooseAvatar(Integer id) {
        String url=photosRepo.findOne(id).getUrl();
        User user=userService.authenticationUser();
        user.setAvatar(url);
        userService.edit(user);
    }

    @Override
    public void deletePicture(Integer id) {
        photosRepo.delete(id);
    }

    @Override
    public List<Photos> allPicture(Integer id) {
        User user=userService.FindById(id);
return photosRepo.findByUser(user);
    }

    @Override
    public List<Photos> allMyPicture() {
        return photosRepo.findByUser(userService.authenticationUser());
    }

    @Override
    public Photos picture(Integer id) {
return photosRepo.findOne(id);
    }

    @Override
    public Integer сheckingUser(Integer id) {
        if (userService.authenticationUser().getId()==photosRepo.findOne(id).getUser().getId()){
            return 1;
        }
        return 2;
    }
}
