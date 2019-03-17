package Service;

import DAO.TweetProvider;
import DAO.UserProvider;
import Domain.Tweet;
import Domain.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class KwetterService {

    @Inject
    private UserProvider userProvider;

    @Inject
    private TweetProvider tweetProvider;

    public KwetterService(){

    }

    public User getUserByName(String username){
        return userProvider.getUserByUsername(username);
    }

    public List<User> getAllUsers(){
        return userProvider.getAllUsers();
    }

    public List<User> getAllFolowing(String username){
        return userProvider.getAllFollowing(username);
    }

    public List<User> getAllFollowers(String username){
        return userProvider.getAllFollowers(username);
    }

    public boolean createUser(User user){
        if(user != null){
            userProvider.createUser(user);
            return true;
        }
        return false;
    }

    public boolean removeUser(User user){
        if(user != null) {
            userProvider.removeUser(user);
            return true;
        }
        return false;
    }

    public boolean editUser(User user){
        if(user != null){
            userProvider.editUser(user);
            return true;
        }
        return false;
    }
}
