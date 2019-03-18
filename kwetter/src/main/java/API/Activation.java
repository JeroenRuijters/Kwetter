package API;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 */
@ApplicationPath("/api/")
public class Activation extends Application {
    private Set<Class<?>> resources = new HashSet<>();

    public Activation(){
        resources.add(UserResource.class);
        resources.add(TweetResource.class);
    }
    @Override
    public Set<Class<?>> getClasses(){
        return resources;
    }
}
