package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class GetPostSteps {

    private static ResponseOptions<Response> response;

    @Given("I perform GET operation for {string}")
    public void iPerformGETOperationFor(String url) {
        response = RestAssuredExtension.getOps(url);
    }

    @Then("I should see the author name as {string}")
    public void iShouldSeeTheAuthorNameAs(String authorName) {
        assertThat(response.getBody().jsonPath().get("author"), hasItem(authorName));
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

    @Given("I perform POST operation for {string}")
    public void iPerformPOSTOperationFor(String arg0) {
        BDDStyledMethod.performPostWithBodyParameter();
    }

    @Given("I perform POST operation for {string} with body")
    public void iPerformPOSTOperationForWithBody(String url, DataTable table) {
        var data = table.cells();

        //Set body
        HashMap<String, String> body = new HashMap<>();
        body.put("name", data.get(1).get(0));

        //Path params
        HashMap<String, String> pathParams = new HashMap<>();
        pathParams.put("profileNo", data.get(1).get(1));

        //Perform POST operation
        response = RestAssuredExtension.postOpsWithBodyAndPathParams(url, pathParams, body);
    }

    @Then("I should see the body has name as {string}")
    public void iShouldSeeTheBodyHasNameAs(String name) {
        assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
    }
}
