package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class Delete {

    private static ResponseOptions<Response> response;

    @Given("I ensure to perform POST operation for {string} with body as")
    public void iEnsureToPerformPOSTOperationForWithBodyAs(String url, DataTable table) {
        var data = table.cells();
        Map<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("author", data.get(1).get(2));

        RestAssuredExtension.postOpsWithBody(url, body);
    }

    @And("I perform DELETE operation for {string}")
    public void iPerformDELETEOperationFor(String url, DataTable table) {
        var data = table.cells();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));

        RestAssuredExtension.deleteOpsWithPathParams(url, pathParams);
    }

    @And("I perform GET operation with path parameter for {string}")
    public void iPerformGETOperationWithPathParameterFor(String url, DataTable table) {
        var data = table.cells();
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));

        response = RestAssuredExtension.getOpsWithPathParams(url, pathParams);
    }

    @Then("I should not see the body with title as {string}")
    public void iShouldNotSeeTheBodyWithTitleAs(String title) {
        assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
    }
}
