import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.*;
import java.util.List;

@NamedQuery(name = "getAll", query = "select T from Tweet T")
@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final long id;
    private String body;

    @ManyToOne(optional = false)
    private User user;
    private List<User> likes;
    private List<User> mentions;
    private List<String> topics;

    public Tweet(User user,  String body, int id){
        this.user = user;
        this.body = body;
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public User getUser(){
        return user;
    }

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

    public void postTweet(){
        throw new NotImplementedException();
    }
}
