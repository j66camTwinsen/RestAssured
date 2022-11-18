package steps;

import io.restassured.http.ContentType;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BDDStyledMethod {

    public static void simpleGetPost(String postNumber) {
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/%s", postNumber)).
                then().body("author", is("Karthik KK"));
    }

    public static void performContainsCollection() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts/")
                .then()
                .body("author", containsInAnyOrder("Karthik KK", "Karthik KK", null)).statusCode(200);
    }

    public static void performPathParameter() {
        given()
                .contentType(ContentType.JSON)
                .with()
                .pathParams("post", 1)
                .when()
                .get("http://localhost:3000/posts/{post}")
                .then()
                .body("author", containsString("Karthik KK"));
    }

    public static void performQueryParameter() {
        given()
                .contentType(ContentType.JSON)
                .with()
                .queryParam("id", 1)
                .when()
                .get("http://localhost:3000/posts/")
                .then()
                .body("author", hasItem("Karthik KK"));
    }

    public static void performPostWithBodyParameter() {
        HashMap<String,String> postContent = new HashMap<>();
        postContent.put("id", "5");
        postContent.put("title", "Robotium Course");
        postContent.put("author", "ExecuteAutomation");

        given()
                .contentType(ContentType.JSON)
                .with()
                .body(postContent)
                .when()
                .post("http://localhost:3000/posts")
                .then()
                .body("author", Is.is("ExecuteAutomation"));
    }

}
