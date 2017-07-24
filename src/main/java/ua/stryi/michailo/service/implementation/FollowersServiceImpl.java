package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.stryi.michailo.entity.Followers;
import ua.stryi.michailo.entity.Followings;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.repo.FollowersRepo;
import ua.stryi.michailo.repo.FollowingsRepo;
import ua.stryi.michailo.service.FollowersService;
import ua.stryi.michailo.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Service
public class FollowersServiceImpl implements FollowersService{
    @Autowired
    UserService userService;
    @Autowired
    FollowersRepo followersRepo;
    @Autowired
    FollowingsRepo followingsRepo;
    @Override
    public void add(Integer id) {

User user1=userService.authenticationUser();
    User user2=userService.FindById(id) ;

    if (followersRepo.findByUser(user2)!=null){

        Followers followers =followersRepo.findByUser(user2);
        List<User>userList1=new ArrayList<>();
        userList1.addAll(followers.getUsers());
        userList1.add(user1);
        followers.setUsers(userList1);
        followersRepo.save(followers);
    }else {
        Followers followers = new Followers();
        List<User> userList1 = new ArrayList<>();
        userList1.add(user1);
        followers.setUsers(userList1);
        followers.setUser(user2);
        followersRepo.save(followers);

    }
    if (followingsRepo.findByUser(user1)!=null){
        Followings followings=followingsRepo.findByUser(user1);
        List<User>userList2=new ArrayList<>();
        userList2.addAll(followings.getUsers());
        userList2.add(user2);
        followings.setUsers(userList2);
        followingsRepo.save(followings);
    }else {
        Followings followings = new Followings();
        List<User> userList2 = new ArrayList<>();
        userList2.add(user2);
        followings.setUsers(userList2);
        followings.setUser(user1);
        followingsRepo.save(followings);
    }
    }
    public void add2(Integer id){
        User user1=userService.FindById(id) ;
        User user2=userService.authenticationUser();

        if (followersRepo.findByUser(user2)!=null){

            Followers followers =followersRepo.findByUser(user2);
            List<User>userList1=new ArrayList<>();
            userList1.addAll(followers.getUsers());
            userList1.add(user1);
            followers.setUsers(userList1);
            followersRepo.save(followers);
        }else {
            Followers followers = new Followers();
            List<User> userList1 = new ArrayList<>();
            userList1.add(user1);
            followers.setUsers(userList1);
            followers.setUser(user2);
            followersRepo.save(followers);

        }
        if (followingsRepo.findByUser(user1)!=null){
            Followings followings=followingsRepo.findByUser(user1);
            List<User>userList2=new ArrayList<>();
            userList2.addAll(followings.getUsers());
            userList2.add(user2);
            followings.setUsers(userList2);
            followingsRepo.save(followings);
        }else {
            Followings followings = new Followings();
            List<User> userList2 = new ArrayList<>();
            userList2.add(user2);
            followings.setUsers(userList2);
            followings.setUser(user1);
            followingsRepo.save(followings);
        }


    }
    @Override
    public List<User> findByAllFollowers(User user) {
        if (followersRepo.findByUser(user)!=null){
            return followersRepo.findByUser(user).getUsers();
        }
        return null;
    }

    @Override
    public List<User> findByAllFollowing(User user) {
        if (followingsRepo.findByUser(user)!=null){
            return followingsRepo.findByUser(user).getUsers();
        }
        return null;
    }

    @Override
    public void delete(Integer id) {

      User user1= userService.FindById(id);
       User user2= userService.authenticationUser();

     Followings followings=followingsRepo.findByUser(user1);
    for (int i = 0; i < followings.getUsers().size(); i++) {
           if (followings.getUsers().get(i).getId()==user2.getId()){
               followings.getUsers().remove(i);
           }
        }

        for (int i = 0; i < followings.getUsers().size(); i++) {
            System.out.println(followings.getUsers().get(i).getName());
            System.out.println(followings.getUsers().get(i).getEmail());
        }
       followingsRepo.save(followings);

       Followers followers=followersRepo.findByUser(user2);
        List<User>userList2=followers.getUsers();
        for (int i = 0; i < userList2.size(); i++) {
            if (userList2.get(i).getId()==user1.getId()){
                userList2.remove(i);
            }
        }
        followers.setUsers(userList2);
        followersRepo.save(followers);
    }

    @Override
    public Followers findByUserFollowers(User user) {
        return followersRepo.findByUser(user);
    }

    @Override
    public Followings findByUserFollowings(User user) {
        return followingsRepo.findByUser(user);
    }

    @Override
    public void deleteFollowings(Integer id) {

    }

    @Override
    public void cancelFollowing(Integer id) {
        User user1=userService.authenticationUser();
        User user2=userService.FindById(id);

        Followers followers=followersRepo.findByUser(user2);
        for (int i = 0; i < followers.getUsers().size(); i++) {
            if (followers.getUsers().get(i).getId()==user1.getId()){
                followers.getUsers().remove(i);
            }
        }
        Followings followings=followingsRepo.findByUser(user1);
        for (int i = 0; i < followings.getUsers().size(); i++) {
            if (followings.getUsers().get(i).getId()==id){
                followings.getUsers().remove(i);
            }
        }
        followingsRepo.save(followings);
        followersRepo.save(followers);

    }

}

