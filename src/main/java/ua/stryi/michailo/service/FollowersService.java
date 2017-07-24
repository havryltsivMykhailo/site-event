package ua.stryi.michailo.service;

import ua.stryi.michailo.entity.Followers;
import ua.stryi.michailo.entity.Followings;
import ua.stryi.michailo.entity.User;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface FollowersService {
    public void add(Integer id);
    public void add2(Integer id);
    public List<User> findByAllFollowers(User user);
    public List<User> findByAllFollowing(User user);
    public void delete(Integer id);
public Followers findByUserFollowers(User user);
public Followings findByUserFollowings(User user);
    public void deleteFollowings(Integer id);
    public void cancelFollowing(Integer id);
}
