package ua.stryi.michailo.service;

import org.springframework.web.multipart.MultipartFile;
import ua.stryi.michailo.entity.Photos;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface PhotosService {

    public void addPictures(MultipartFile multipartFile);
    public  void addAvatarPicture(MultipartFile multipartFile);
    public void chooseAvatar(Integer id);
    public void deletePicture(Integer id);
    public List<Photos> allPicture(Integer id);
    public List<Photos> allMyPicture();
    public Photos picture(Integer id);
public Integer сheckingUser(Integer id);
}
