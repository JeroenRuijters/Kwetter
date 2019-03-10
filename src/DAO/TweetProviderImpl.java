package DAO;

import Domain.Tweet;

import java.util.List;

@Stateless
public class TweetProviderImpl implements TweetProvider {
    @Override
    public void createTweet(Tweet tweet) {

    }

    @Override
    public List<Tweet> getAll() {
        return null;
    }

    @Override
    public List<Tweet> getTweetByUsername(String username) {
        return null;
    }
}
