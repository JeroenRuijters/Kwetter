package Service;

import DAO.TweetProvider;
import DAO.UserProvider;
import Domain.Tweet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TweetService {

    @Inject
    private TweetProvider tweetProvider;

    public TweetService(){

    }

    public boolean createTweet(Tweet tweet){
        if(tweet != null) {
            tweetProvider.createTweet(tweet);
            return true;
        }
        return false;
    }

    public boolean removeTweet(Tweet tweet){
        if(tweet != null){
            tweetProvider.removeTweet(tweet);
            return true;
        }
        return false;
    }

    public boolean editTweet(Tweet tweet){
        if(tweet != null){
            tweetProvider.editTweet(tweet);
            return  false;
        }
        return true;
    }

    public List<Tweet> getAllTweets(){
        return tweetProvider.getAll();
    }

    public List<Tweet> getTweetsByUsername(String username){
        return tweetProvider.getTweetByUsername(username);
    }

    public Tweet getTweetById(long id){
        return tweetProvider.getTweetById(id);
    }

    public List<Tweet> searchTweets(String searchterm){
        return tweetProvider.searchTweets(searchterm);
    }

    public void setTweetProvider(TweetProvider tweetProvider){
        this.tweetProvider = tweetProvider;
    }
}
