package ua.stryi.michailo.entity;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Entity
public class Followers {
@Id
@GeneratedValue
private int id;
private GregorianCalendar date;
//@ManyToOne
//private User following;
//@ManyToOne
//private User followers;
@ManyToOne(fetch = FetchType.EAGER)
private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_followers",joinColumns = @JoinColumn(name = "followers_id"),inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    public Followers() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
