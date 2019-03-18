package Service;

import DAO.UserProvider;
import Domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserProvider userProvider;


    private User testUser;
    private User testUser2;

    public UserServiceTest(){

    }

    @Before
    public void setUp(){
        userService = new UserService();
        userService.setUserProvider(userProvider);

        testUser = new User("Jeroen", "ik", "1234567890");
        testUser2 = new User("Henk", "Boekhouder", "password1");

    }

    @Test
    public void createUserTest(){
        userService.createUser(testUser);
        verify(userProvider, Mockito.times(1)).createUser(testUser);

    }
    @Test
    public void getAllUsersTest(){
        userService.createUser(testUser2);
        userService.getAllUsers();
        verify(userProvider, Mockito.times(1)).getAllUsers();
    }

    @Test
    public void getUserByNameTest(){
        userService.getUserByName("Jeroen");
        verify(userProvider, Mockito.times(1)).getUserByUsername("Jeroen");
    }

    @Test
    public void editUserTest(){
        testUser.setBio("Dit is nu anders");
        userService.editUser(testUser);
        verify(userProvider, Mockito.times(1)).editUser(testUser);
    }

    @Test
    public void addFollower(){
        userService.addFollower("Jeroen", "Henk");
        verify(userProvider, Mockito.times(1)).addFollower("Jeroen", "Henk");
    }

    @Test
    public void getAllFollowersTest(){
        userService.getAllFollowers("Henk");
        verify(userProvider, Mockito.times(1)).getAllFollowers("Henk");
    }

    @Test
    public void getAllFollowingTest(){
        userService.getAllFollowing("Jeroen");
        verify(userProvider, Mockito.times(1)).getAllFollowing("Jeroen");
    }

    @Test
    public void removeFollowerTest(){
        userService.removeFollower("Jeroen", "Henk");
        verify(userProvider, Mockito.times(1)).removeFollower("Jeroen", "Henk");
    }

    @Test
    public void removeUserTest(){
        userService.removeUser(testUser);
        verify(userProvider, Mockito.times(1)).removeUser(testUser);
    }
}
