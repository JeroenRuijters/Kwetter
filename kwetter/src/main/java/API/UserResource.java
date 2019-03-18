package API;

import Domain.Tweet;
import Domain.User;
import Service.TweetService;
import Service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
//@TokenRequired(requiredPermissionGroup = Role.User)
public class UserResource {

    @Inject
    UserService userService;

    @Inject
    TweetService tweetService;

    @GET
    public String getAll(){
        /*System.out.print('d');
        final List<JsonObject> allUsers = new ArrayList<JsonObject>();
        userService.getAllUsers().forEach(user -> allUsers.add(user.toJson()));
        return Response.ok(allUsers).build();*/
        return "Hello World";
    }

    @GET
    @Path("{username}")
    public Response findUser(@PathParam("username") String username) {
        return Response.ok(userService.getUserByName(username)).build();
    }

    @POST
    public Response addUser(User user) {
        System.out.print('f');
        userService.createUser(user);
        return Response.ok().build();
    }

    @POST
    @Path("{username}")
    public Response editUser(@PathParam("username") String username, User user) {
        userService.editUser(user);
        return Response.ok().build();
    }

    @DELETE
    @Path("{username}")
    public Response deleteUser(@PathParam("username") String username) {
        User user = userService.getUserByName(username);
        userService.removeUser(user);
        return Response.ok().build();
    }

    @GET
    @Path("{username}/followers")
    public Response getUserFollowers(@PathParam("username") String username) {
        List<User> list = userService.getAllFollowers(username);
        return Response.ok(list).build();
    }


    @GET
    @Path("{username}/following")
    public Response getUserFollowing(@PathParam("username") String username) {
        List<User> list = userService.getAllFollowing(username);
        return Response.ok(list).build();
    }

    @GET
    @Path("{username}/tweets")
    public Response getUserTweets(@PathParam("username") String username) {
        return Response.ok(userService.getUserByName(username).getAllTweets()).build();
    }

    @GET
    @Path("{username}/recenttweets")
    public Response getRecentUserTweets(@PathParam("username") String username) {
        return Response.ok(userService.getUserByName(username).getAllRecentTweets(10)).build();
    }

    @PUT
    @Path("{username}/tweets")
    public Response postTweet(@PathParam("username") String username, Tweet tweet) {
        tweetService.createTweet(tweet);
        return Response.ok().build();
    }

    @PUT
    @Path("{username}/followers/{newfollower}")
    public Response addFollower(@PathParam("username") String username, @PathParam("newfollower") String newFollowerName) {
        userService.addFollower(username,newFollowerName);
        return Response.ok().build();
    }

    @DELETE
    @Path("{username}/followers/{oldfollower}")
    public Response removeFollower(@PathParam("username") String username, @PathParam("oldfollower") String oldFollowerName) {
        userService.removeFollower(username,oldFollowerName);
        return Response.ok().build();
    }
}
