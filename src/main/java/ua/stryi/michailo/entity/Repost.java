package ua.stryi.michailo.entity;

import javax.persistence.*;
import java.util.GregorianCalendar;

/**
 * Created by михайло on 07.05.2017.
 */
@Entity
public class Repost {
@Id
@GeneratedValue
    private int id;
    @Column( length =10000)
private String description;
    private GregorianCalendar date;
    @ManyToOne
    private UserEvent event;
    @ManyToOne
    private User user;
    @OneToOne
    private Article article;
    public Repost() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEvent getEvent() {
        return event;
    }

    public void setEvent(UserEvent event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}
