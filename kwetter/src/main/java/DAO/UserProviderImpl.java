package DAO;

import Domain.User;
import Logic.PasswordHash;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserProviderImpl implements UserProvider{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void addFollower(String username, String followername) {
        User user = this.getUserByUsername(username);
        user.addFollower(this.getUserByUsername(followername));
        entityManager.merge(user);
    }

    @Override
    public void removeFollower(String username, String followername) {
        User user = this.getUserByUsername(username);
        user.removeFollower(this.getUserByUsername(followername));
        entityManager.merge(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createNamedQuery("getAllUsers", User.class).getResultList();
    }

    @Override
    public User getUserByUsername(String username) {
        return (User) entityManager.createNamedQuery("getUserByUsername", User.class).setParameter("username", username);
    }

    @Override
    public List<User> getAllFollowing(String username) {
        User user = this.getUserByUsername(username);
        return user.getFollowing();
    }

    @Override
    public List<User> getAllFollowers(String username) {
        User user = this.getUserByUsername(username);
        return user.getFollowers();
    }

    @Override
    public User authenticateUser(String login, String password) {
        Query query = entityManager.createNamedQuery("authenticateUser", User.class);
        query.setParameter("username", login);
        query.setParameter("password", PasswordHash.stringToHash(password));
        List<User> result = query.getResultList();
        if (result.size() <= 0){
            return null;
        }
        return result.get(0);
    }
}
