package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojos.post.PostPojo;
import utilities.RestAssuredExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Get {

    private static ResponseOptions<Response> response;

    @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) {
        response = RestAssuredExtension.getOps(url);
    }

    @Then("I should see the author name as {string}")
    public void iShouldSeeTheAuthorNameAs(String authorName) {
        var posts = response.getBody().as(PostPojo.class);
        assertThat(posts.getAuthor(), equalTo(authorName));
        //assertThat(response.getBody().jsonPath().get("author"), hasItem(authorName));
    }

    @Then("I should see the author names")
    public void iShouldSeeTheAuthorNames() {
        BDDStyledMethod.performContainsCollection();
    }

    @Then("I should verify Path Parameter")
    public void iShouldVerifyPathParameter() {
        BDDStyledMethod.performPathParameter();
    }

    @Then("I should verify Query Parameter")
    public void iShouldVerifyQueryParameter() {
        BDDStyledMethod.performQueryParameter();
    }
}
