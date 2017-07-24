package ua.stryi.michailo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 07.05.2017.
 */
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private int id;
    private String comment;
    private GregorianCalendar date;
@ManyToOne(fetch = FetchType.EAGER)
private User author;
@ManyToOne(fetch = FetchType.EAGER)
private UserEvent userEvent;
@ManyToOne
@JsonIgnore
private Photos photos;
@OneToMany(mappedBy = "comment",fetch = FetchType.EAGER)
private List<Likes> likes;
@ManyToOne
private Article article;
    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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



    public UserEvent getUserEvent() {
        return userEvent;
    }

    public void setUserEvent(UserEvent userEvent) {
        this.userEvent = userEvent;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
