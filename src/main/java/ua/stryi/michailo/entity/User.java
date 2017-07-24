package ua.stryi.michailo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by михайло on 07.05.2017.
 */
@Entity
public class User {
@Id
@GeneratedValue
 private int id;
private String name;
private String secondName;
private GregorianCalendar age;
private GregorianCalendar date;
private String city;
private String email;
private String phone;
private String password;
private String avatar;
private String activator;
private boolean active;
private String gender;


@ManyToMany
@JsonIgnore
@JoinTable(name = "user_friends",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "friends_id"))
private List<Friends>friendsList;
@ManyToMany
@JsonIgnore
@JoinTable(name = "user_followings",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "followings_id"))
    private List<Followings>followingsList;

@ManyToMany
@JsonIgnore
@JoinTable(name = "user_followers",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "followers_id"))
    private List<Followers>followersList;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Friends>friends;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Followers>followers;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Followings>followings;
@OneToMany(mappedBy = "sender")
@JsonIgnore
private List<Message>sentMessages;
@OneToMany(mappedBy = "recipient")
@JsonIgnore
private List<Message>receivedMessages;
@OneToMany(mappedBy = "author")
@JsonIgnore
private List<Comment>comments;
@OneToMany(mappedBy = "user")
@JsonIgnore
private List<Repost>repostList;
@OneToMany(mappedBy = "author")
@JsonIgnore
private List<UserEvent>eventList;
@OneToMany(mappedBy = "author")
@JsonIgnore
private List<Likes>likes;
@OneToMany(mappedBy = "user")
@JsonIgnore
private List<Participate>participateList;
@OneToMany(mappedBy = "user")
@JsonIgnore
private List<PerhapsParticipate>perhapsParticipates;
@OneToMany(mappedBy = "user")
@JsonIgnore
private List<Photos> photos;
@OneToMany(mappedBy = "user")
@JsonIgnore
private List<MessageList>messageListList;
@OneToMany(mappedBy = "userMesage")
@JsonIgnore
private List<MessageList>messageLists;
    @OneToMany(mappedBy = "author")
    @JsonIgnore
private List<Article>articles;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Article>article;

    public User() {


        this.activator = RandomStringUtils.random(10,true,true);
        this.active = false;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getActivator() {
        return activator;
    }

    public void setActivator(String activator) {
        this.activator = activator;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Friends> getFriends() {
        return friends;
    }

    public void setFriends(List<Friends> friends) {
        this.friends = friends;
    }

    public List<Friends> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<Friends> friendsList) {
        this.friendsList = friendsList;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Repost> getRepostList() {
        return repostList;
    }

    public void setRepostList(List<Repost> repostList) {
        this.repostList = repostList;
    }

    public List<UserEvent> getEventList() {
        return eventList;
    }

    public void setEventList(List<UserEvent> eventList) {
        this.eventList = eventList;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
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

    public List<Followings> getFollowingsList() {
        return followingsList;
    }

    public void setFollowingsList(List<Followings> followingsList) {
        this.followingsList = followingsList;
    }

    public List<Followers> getFollowersList() {
        return followersList;
    }

    public void setFollowersList(List<Followers> followersList) {
        this.followersList = followersList;
    }

    public List<Followers> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Followers> followers) {
        this.followers = followers;
    }

    public List<Followings> getFollowings() {
        return followings;
    }

    public void setFollowings(List<Followings> followings) {
        this.followings = followings;
    }

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }

    public GregorianCalendar getAge() {
        return age;
    }

    public void setAge(GregorianCalendar age) {
        this.age = age;
    }

    public List<MessageList> getMessageListList() {
        return messageListList;
    }

    public void setMessageListList(List<MessageList> messageListList) {
        this.messageListList = messageListList;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }

    public List<MessageList> getMessageLists() {
        return messageLists;
    }

    public void setMessageLists(List<MessageList> messageLists) {
        this.messageLists = messageLists;
    }
}
