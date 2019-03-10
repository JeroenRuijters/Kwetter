package Domain;

import com.sun.xml.internal.bind.v2.TODO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;
import java.util.List;

public class User {
    private String username;
    private final int id;
    private Image profilePicture;
    private String bio;
    private List<Tweet> tweets;
    private List<User> followers;
    private List<User> following;
    private List<Role> roles;

    public User(String username, int id){
        this.username = username;
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public Image getProfilePicture(){
        return profilePicture;
    }

    public void setProfilePicture(){
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

    public Tweet getTweetById(int id){
        throw new NotImplementedException();
    }

    public List<User> getFollowers(){
        return followers;
    }

    public void addFolower(User follower){
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
