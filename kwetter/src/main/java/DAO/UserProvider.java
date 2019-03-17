package DAO;

import Domain.User;

import java.util.List;

public interface UserProvider {

    void createUser(User user);

    void editUser(User user);

    void removeUser(User user);

    List<User> getAllUsers();

    User getUserByUsername(String Username);

    List<User> getAllFollowing(String username);

}
