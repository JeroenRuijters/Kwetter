package Domain;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NamedQueries({@NamedQuery(name = "getAll", query = "select T from Tweet T"),
               @NamedQuery(name = "getTweetByUsername", query = "select T from Tweet T where T.user = (select u from User u where u.username = :param)"),
               @NamedQuery(name = "getNumberOfTweets", query = "select T from Tweet T where T.user = (select u from User u where u.username = :param)"),
               @NamedQuery(name = "searchTweets", query = "select T from Tweet T where T.body like :param"),
               @NamedQuery(name = "getTweetById", query = "select T from Tweet T where T.id = :id")
})
@Entity
public class Tweet implements Comparable<Tweet> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String body;
    private Date dateTime;

    @ManyToOne(optional = false)
    private User user;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> likes;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> mentions;
    @ElementCollection
    private List<String> topics;

    public Tweet(User user,  String body){
        this.user = user;
        this.body = body;
        this.dateTime = new Date();
    }

    public Tweet() {
    }

    public long getId(){
        return id;
    }

    public void setId(long id){ this.id = id; }

    public User getUser(){
        return user;
    }

    public Date getDateTime() { return dateTime; }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getNumberOfLikes(){
        return likes.size();
    }

    public List<User> getLikes() {
        return likes;
    }

    public void addLike(User user) {
        likes.add(user);
    }

    public void addMention(User user){
        mentions.add(user);
    }

    public List<User> getMentions() {
        return mentions;
    }

    public void addTopic(String topic){
        topics.add(topic);
    }

    public List<String> getTopics() {
        return topics;
    }

    @Override
    public int compareTo(Tweet tweet) {
        return tweet.getDateTime().compareTo(getDateTime());
    }
}
