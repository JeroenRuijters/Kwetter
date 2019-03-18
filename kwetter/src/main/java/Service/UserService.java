package Service;

import DAO.UserProvider;
import Domain.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UserService {

    @Inject
    private UserProvider userProvider;

    public UserService(){

    }

    public User getUserByName(String username){
        return userProvider.getUserByUsername(username);
    }

    public List<User> getAllUsers(){
        return userProvider.getAllUsers();
    }

    public List<User> getAllFollowing(String username){
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

    public void addFollower(String username, String followername){
        userProvider.addFollower(username, followername);
    }

    public void removeFollower(String username, String followername){
        userProvider.removeFollower(username, followername);
    }

    public User authenticateUser(String login, String password){
        return userProvider.authenticateUser(login, password);
    }

    public void setUserProvider(UserProvider userProvider){
        this.userProvider = userProvider;
    }
}
