package API;

import Service.UserService;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;

public class UserResourceTest {

    @Inject
    UserService userService;

    private String baseUrl = "Kwetter_war_exploded/api/users/";

    @BeforeClass
    public static void setUp() {
        given().body("{ \"username\" : \"jeroen\", \"bio\" : \"test bio\", \"password\" : \"12345\" }").when().contentType(ContentType.JSON).put("Kwetter_war_exploded/api/users").then().statusCode(200);

    }

    @Test
    public void getAllUsersTest(){
        get(baseUrl);
    }
}
