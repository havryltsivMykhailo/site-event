package ua.stryi.michailo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 08.05.2017.
 */
@Entity
public class UserEvent {
@Id
@GeneratedValue
    private int id;
    private String category;
    private String name;
    private GregorianCalendar startDate;
    private GregorianCalendar dateOfCompletion;
    private String location;
    @Column( length =10000)
    private String title;
    @Column(length = 9999999)
    private String text;
    private String photo;
    private String link;
    @ManyToOne
    private User author;
    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Likes>likes;
    @OneToMany(mappedBy = "userEvent",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Comment>commentList;
    @OneToMany(mappedBy = "event",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Repost>repostList;
    @OneToMany(mappedBy = "event",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Participate>participateList;
    @OneToMany(mappedBy = "event",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<PerhapsParticipate>perhapsParticipates;

    public UserEvent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public GregorianCalendar getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(GregorianCalendar dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public List<Repost> getRepostList() {
        return repostList;
    }

    public void setRepostList(List<Repost> repostList) {
        this.repostList = repostList;
    }

    public List<Participate> getParticipateList() {
        return participateList;
    }

    public void setParticipateList(List<Participate> participateList) {
        this.participateList = participateList;
    }

    public List<PerhapsParticipate> getPerhapsParticipates() {
        return perhapsParticipates;
    }

    public void setPerhapsParticipates(List<PerhapsParticipate> perhapsParticipates) {
        this.perhapsParticipates = perhapsParticipates;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
