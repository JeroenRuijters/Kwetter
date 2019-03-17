package DAO.API;

import Annotations.TokenRequired;
import Domain.Role;
import Service.TweetService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("tweets")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@TokenRequired(requiredPermisionGroup = Role.User)
public class TweetResource {

    @Inject
    TweetService tweetService;

    @GET
    public Response getAll(){
        return Response.ok(tweetService.getAllTweets()).build();
    }


}
