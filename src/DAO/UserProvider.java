package DAO;

import Domain.User;

public interface UserProvider {

    public User findUserByName(String name);
    
}
