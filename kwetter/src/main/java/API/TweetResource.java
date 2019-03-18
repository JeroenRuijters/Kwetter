package API;

import Annotations.TokenRequired;
import Domain.Role;
import Service.TweetService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("tweets")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
//@TokenRequired(requiredPermissionGroup = Role.User)
public class TweetResource {

    @Inject
    TweetService tweetService;

    @GET
    public Response getAll(){
        return Response.ok(tweetService.getAllTweets()).build();
    }

    @GET
    @Path("search")
    public Response searchTweets(@QueryParam("searchTerm") String searchTerm) {
        return Response.ok(tweetService.searchTweets(searchTerm)).build();
    }

    @GET
    @Path("{id}")
    public Response getTweet(@PathParam("id") long id) {
        return Response.ok(tweetService.getTweetById(id)).build();
    }
}
