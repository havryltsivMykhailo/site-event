package ua.stryi.michailo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.stryi.michailo.entity.Photos;
import ua.stryi.michailo.entity.User;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface PhotosRepo extends JpaRepository<Photos,Integer> {
    public List<Photos> findByUser(User user);
}
