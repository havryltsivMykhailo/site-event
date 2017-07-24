package ua.stryi.michailo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by михайло on 07.05.2017.
 */
@Entity
public class Friends {
@Id
@GeneratedValue
private int id;
@ManyToOne
private User user;
@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "user_friends",joinColumns = @JoinColumn(name = "friends_id"),inverseJoinColumns = @JoinColumn(name = "user_id"))
 private List<User>userList;

    public Friends() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
