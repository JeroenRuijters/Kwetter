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
        return (List<Tweet>) entityManager.createNamedQuery("Domain.Tweet.getAll", Tweet.class).getResultList();
    }

    @Override
    public List<Tweet> getTweetByUsername(String username) {
        return (List<Tweet>) entityManager.createQuery("select T from Domain.Tweet T where T.Username = :param").setParameter("param", username).getResultList();
    }
}
