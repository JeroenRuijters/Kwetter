package Domain;

import Logic.PasswordHash;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.util.List;

@NamedQueries ({ @NamedQuery(name = "getAllUsers", query = "select U from User U"),
                 @NamedQuery(name = "getUserByUsername", query = "select U from User U where U.username = :username"),
                 @NamedQuery(name = "authenticateUser", query = "SELECT s FROM User s WHERE s.username = :username AND s.password = :password")
})
@Entity
public class User {
    private String username;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String profilePicture;
    private String bio;
    private String password;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Tweet> tweets;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> followers;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> following;
    @ElementCollection
    private List<Role> roles;

    public User(String username, String bio, String password){
        this.username = username;
        this.bio = bio;
        this.password = PasswordHash.stringToHash(password);
    }

    public User() {
    }

    public long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getProfilePicture(){
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture){
        this.profilePicture = profilePicture;
    }

    public String getBio(){
        return bio;
    }

    public void setBio(String bio){
        this.bio = bio;
    }

    public void addTweet(Tweet tweet){
        tweets.add(tweet);
    }

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public List<Tweet> getAllTweets(){
        return tweets;
    }

    public List<Tweet> getAllRecentTweets(int amount){
        throw new NotImplementedException();
    }

    public Tweet getTweetById(long id){
        throw new NotImplementedException();
    }

    public List<User> getFollowers(){
        return followers;
    }

    public void removeFollower(User user){
        followers.remove(user);
    }

    public void addFollower(User follower){
        followers.add(follower);
    }

    public List<User> getFollowing(){
        return following;
    }

    public void addFollowing(User user){
        following.add(user);
    }

    public List<Role> getRoles(){
        return roles;
    }

    public void setRoles(Role role){
        roles.add(role);
    }
}
