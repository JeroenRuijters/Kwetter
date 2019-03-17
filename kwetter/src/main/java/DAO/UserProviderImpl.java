import Domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public List<User> getAllUsers() {
        return (List<User>) entityManager.createNamedQuery("Domain.User.getAllUsers", User.class).getResultList();
    }

    @Override
    public User getUserByUsername(String username) {
        return (User) entityManager.createQuery("select U from Domain.User U where U.username = :param").setParameter("param", username);
    }

    @Override
    public List<User> getAllFollowing(String username) {
        User user = this.getUserByUsername(username);
        return user.getFollowing();
    }

}
