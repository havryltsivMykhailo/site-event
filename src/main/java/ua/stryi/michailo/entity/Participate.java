package ua.stryi.michailo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by михайло on 08.05.2017.
 */
@Entity
public class Participate {
@Id
@GeneratedValue
private int id;
@ManyToOne
private User user;
@ManyToOne
private  UserEvent event;


    public Participate() {
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

    public UserEvent getEvent() {
        return event;
    }

    public void setEvent(UserEvent event) {
        this.event = event;
    }


}
