package ua.stryi.michailo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Entity
public class Message {
@Id
@GeneratedValue
private int id;
private String name;
private String message;
private GregorianCalendar date;
@ManyToOne
private User sender;
@ManyToOne
private User recipient;
@ManyToMany
@JsonIgnore
@JoinTable(name = "message_messagelist",joinColumns = @JoinColumn(name = "message_id"),inverseJoinColumns = @JoinColumn(name = "messagelist_id"))
private List<MessageList> messageList;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MessageList> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageList> messageList) {
        this.messageList = messageList;
    }
}
