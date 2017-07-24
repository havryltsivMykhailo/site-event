package ua.stryi.michailo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.GregorianCalendar;

/**
 * Created by михайло on 07.05.2017.
 */
@Entity
public class Likes{
    @Id
    @GeneratedValue
    private int id;
    private String name;
private GregorianCalendar date;
@ManyToOne
private User author;
    @JsonIgnore
@ManyToOne
private UserEvent event;
@ManyToOne
@JsonIgnore
private Photos photos;
@ManyToOne
@JsonIgnore
private  Comment comment;
@ManyToOne
private Article article;

    public Likes() {
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

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public UserEvent getEvent() {
        return event;
    }

    public void setEvent(UserEvent event) {
        this.event = event;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
