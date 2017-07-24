package ua.stryi.michailo.entity;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 18.05.2017.
 */
@Entity
public class MessageList {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String message;
    private GregorianCalendar date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "message_messagelist",joinColumns = @JoinColumn(name = "messagelist_id"),inverseJoinColumns = @JoinColumn(name = "message_id"))
    List<Message> messageLists;
    @ManyToOne
    User user;
    @ManyToOne
    User userMesage;

    public MessageList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public List<Message> getMessageLists() {
        return messageLists;
    }

    public void setMessageLists(List<Message> messageLists) {
        this.messageLists = messageLists;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserMesage() {
        return userMesage;
    }

    public void setUserMesage(User userMesage) {
        this.userMesage = userMesage;
    }

}


