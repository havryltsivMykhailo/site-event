package ua.stryi.michailo.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by михайло on 25.06.2017.
 */@Entity
public class Followings {
     @Id
     @GeneratedValue
     private int id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_followings",joinColumns = @JoinColumn(name = "followings_id"),inverseJoinColumns = @JoinColumn(name = "user_id"))
     private List<User>users;
    @ManyToOne
    private User user;

    public Followings() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
