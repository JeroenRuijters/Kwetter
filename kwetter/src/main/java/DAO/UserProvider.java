package DAO;

import Domain.User;

import java.util.List;

public interface UserProvider {

    void createUser(User user);

    void editUser(User user);

    void removeUser(User user);

    void addFollower(String username, String followername);

    void removeFollower(String username, String followername);

    List<User> getAllUsers();

    User getUserByUsername(String Username);

    List<User> getAllFollowing(String username);

    List<User> getAllFollowers(String username);

    User authenticateUser(String login, String password);

}
