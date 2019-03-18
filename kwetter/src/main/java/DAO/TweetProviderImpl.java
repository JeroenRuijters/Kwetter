package DAO;

import Domain.Tweet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TweetProviderImpl implements TweetProvider {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void createTweet(Tweet tweet) {
        entityManager.persist(tweet);
    }

    @Override
    public List<Tweet> getAll() {
        return entityManager.createNamedQuery("getAll", Tweet.class).getResultList();
    }

    @Override
    public List<Tweet> getTweetByUsername(String username) {
        return entityManager.createNamedQuery("getTweetByUsername", Tweet.class).setParameter("param", username).getResultList();
    }

    @Override
    public List<Tweet> getNumberOfTweets(String username, int amount) {
        return entityManager.createNamedQuery("getNumberOfTweets", Tweet.class).setParameter("param", username).getResultList();
    }

    @Override
    public List<Tweet> searchTweets(String searchTerm) {
        return (List<Tweet>) entityManager.createNamedQuery("searchTweets", Tweet.class).setParameter("param", "%" + searchTerm + "%");
    }

    @Override
    public Tweet getTweetById(long id) {
        return (Tweet) entityManager.createNamedQuery("getTweetById", Tweet.class).setParameter("id", id);
    }

    @Override
    public void editTweet(Tweet tweet) {
        entityManager.merge(tweet);
    }

    @Override
    public void removeTweet(Tweet tweet) {
        entityManager.remove(tweet);
    }
}
