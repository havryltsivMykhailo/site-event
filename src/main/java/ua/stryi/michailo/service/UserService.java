package ua.stryi.michailo.service;

import ua.stryi.michailo.entity.User;

import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
public interface UserService {

void add(User user,String dates);
void edit(User user);
void delete(int id);
User FindById(Integer id);
User FindByLogin(String login);
User FindByEmail(String email);
List<User> FindAll();
void activ(String activator);
public String authenticationUserName();
public User authenticationUser();
List<User> findByUser(String a);
}
