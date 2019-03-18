package Service;

import DAO.TweetProvider;
import DAO.TweetProviderImpl;
import DAO.UserProvider;
import Domain.Tweet;
import Domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TweetServiceTest {

    @InjectMocks
    private TweetProviderImpl tweetProvider;

    @Mock
    private TweetService tweetService;

    private User testUser;
    private Tweet testTweet;

    @Before
    public void setUp(){
        tweetService = new TweetService();

        testUser = new User("Jeroen", "ik", "1234567890");
        testTweet = new Tweet(testUser, "Dit is een test");

    }

    @Test
    public void createTweetTest(){
        tweetService.createTweet(testTweet);
        verify(tweetProvider, Mockito.times(1)).createTweet(testTweet);
    }

    @Test
    public void editTweetTest(){
        testTweet.setBody("Wow, de text is veranderd");
        tweetService.editTweet(testTweet);
        verify(tweetProvider, Mockito.times(1)).editTweet(testTweet);
    }

    @Test
    public void getAllTweetsTest(){
        tweetService.getAllTweets();
        verify(tweetProvider, Mockito.times(1)).getAll();
    }

    @Test
    public void getTweetByIdTest() {
        testTweet.setId(1);
        tweetService.getTweetById(1);
        verify(tweetProvider, Mockito.times(1)).getTweetById(1);
    }

    @Test
    public void searchTweetsTest(){
        tweetService.searchTweets("Wow, de text is veranderd");
        verify(tweetProvider, Mockito.times(1)).searchTweets("Wow, de text is veranderd");
    }

    @Test
    public void getTweetByUsernameTest(){
        tweetService.getTweetsByUsername("Jeroen");
        verify(tweetProvider, Mockito.times(1)).getTweetByUsername("Jeroen");
    }

    @Test
    public void removeTweetTest(){
        tweetService.removeTweet(testTweet);
        verify(tweetProvider, Mockito.times(1)).removeTweet(testTweet);
    }
}
