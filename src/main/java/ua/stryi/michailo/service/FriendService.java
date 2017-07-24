package ua.stryi.michailo.service;

import ua.stryi.michailo.entity.User;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface FriendService {
    public void add(Integer id);
    public List<User> all(User user);
    public void delete(Integer id);
    public Integer сheckingForFriendship(Integer id);
}
