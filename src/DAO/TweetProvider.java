package DAO;

import Domain.Tweet;

import java.util.List;

public interface TweetProvider {

    void createTweet(Tweet tweet);

    List<Tweet> getAll();

    List<Tweet> getTweetByUsername(String username);
}
