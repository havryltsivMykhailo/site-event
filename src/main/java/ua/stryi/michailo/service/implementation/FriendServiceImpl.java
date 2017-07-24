package ua.stryi.michailo.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.stryi.michailo.entity.Friends;
import ua.stryi.michailo.entity.User;
import ua.stryi.michailo.repo.FriendsRepo;
import ua.stryi.michailo.service.FollowersService;
import ua.stryi.michailo.service.FriendService;
import ua.stryi.michailo.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Service
public class FriendServiceImpl implements FriendService{
    @Autowired
    UserService userService;
    @Autowired
    FriendsRepo friendsRepo;
    @Autowired
    FollowersService followersService;

    @Override
    public void add(Integer id) {
       User user1= userService.FindById(id);

       User user2=userService.authenticationUser();
        List<User>friendsList1=new ArrayList<>();

        if (friendsRepo.findByUser(user1)!=null){
Friends friends=friendsRepo.findByUser(user1);
friendsList1=friends.getUserList();
friendsList1.add(user2);
friends.setUserList(friendsList1);
friendsRepo.save(friends);

        }else {
            Friends friends=new Friends();
            friendsList1.add(user2);
            friends.setUserList(friendsList1);
            friends.setUser(user1);
            friendsRepo.save(friends);

        }
        List<User>friendsList2=new ArrayList<>();

        if (friendsRepo.findByUser(user2)!=null){
            Friends friends=friendsRepo.findByUser(user2);
            friendsList2.add(user1);
            friends.setUserList(friendsList2);
            friendsRepo.save(friends);

        }else {
            Friends friends=new Friends();
            friendsList2.add(user1);
            friends.setUserList(friendsList2);
            friends.setUser(user2);
            friendsRepo.save(friends);


        }

followersService.delete(id);


    }

    @Override
    public List<User> all(User users) {
        List<User>friendsList1=new ArrayList<>();
if (friendsRepo.findByUser(users)!=null) {
    friendsList1.addAll(friendsRepo.findByUser(users).getUserList());
}return friendsList1;
    }
    @Override
    public void delete(Integer id) {
        User user1=userService.authenticationUser();
      User user2= userService.FindById(id);
     Friends friends1=friendsRepo.findByUser(user2);
     Friends friends2=friendsRepo.findByUser(user1);

        for (int i = 0; i < friends1.getUserList().size(); i++) {
            if (friends1.getUserList().get(i).getId()==user1.getId()){
            friends1.getUserList().remove(i);}
        }
        for (int i = 0; i < friends2.getUserList().size(); i++) {
            if (friends2.getUserList().get(i).getId()==id){
                friends2.getUserList().remove(i);}
        }
        friendsRepo.save(friends1);
        friendsRepo.save(friends2);
        followersService.add2(id);




    }

    @Override
    public Integer сheckingForFriendship(Integer id) {
        User user=userService.authenticationUser();
        if (user.getId()==id){
            return 5;
        }
        if (friendsRepo.findByUser(user)!=null){
        for (int i = 0; i < friendsRepo.findByUser(user).getUserList().size(); i++) {
            if (friendsRepo.findByUser(user).getUserList().get(i).getId()==id){
                return 1;
            }
        }
        }
       if (followersService.findByUserFollowings(user)!=null) {
           for (int i = 0; i < followersService.findByUserFollowings(user).getUsers().size(); i++) {
               if (followersService.findByUserFollowings(user).getUsers().get(i).getId() == id) {
               return 2;
               }
           }
       }

        if (followersService.findByUserFollowers(user)!=null) {
            for (int i = 0; i < followersService.findByUserFollowers(user).getUsers().size(); i++) {
                if (followersService.findByUserFollowers(user).getUsers().get(i).getId() == id) {
                    return 3;
                }
            }
        }

        return 4;
    }
}
