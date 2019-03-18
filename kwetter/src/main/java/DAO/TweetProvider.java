package DAO;

import Domain.Tweet;
import Domain.User;

import java.util.List;

public interface TweetProvider {

    void createTweet(Tweet tweet);

    List<Tweet> getAll();

    List<Tweet> getTweetByUsername(String username);

    List<Tweet> getNumberOfTweets(String username, int amount);

    List<Tweet> searchTweets(String searchTerm);

    Tweet getTweetById(long id);

    void editTweet(Tweet tweet);

    void removeTweet(Tweet tweet);
}
