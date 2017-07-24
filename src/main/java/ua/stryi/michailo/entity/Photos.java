package ua.stryi.michailo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Entity
public class Photos {
@Id
@GeneratedValue
private int id;
private String url;
private GregorianCalendar date;
@ManyToOne
private User user;
@OneToOne
private Article article;
@OneToMany(mappedBy = "photos" )
@JsonIgnore
private List<Comment>commentList;
@OneToMany(mappedBy = "photos")
@JsonIgnore
private List<Likes>likes;

    public Photos() {
    }

    public Photos(String url, GregorianCalendar date) {
        this.url = url;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
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
