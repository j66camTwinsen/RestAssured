package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.APIUtilities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class Divisions {

    private ResponseOptions<Response> response;

    @Given("User sends a GET request to the endpoint \\(Divisions)")
    public void userSendsAGETRequestToTheEndpointDivisions() {
        String resource = "/v2/divisions";
        response = APIUtilities.get(resource);
    }

    @Then("User validates that the {string} has this {string} \\(Divisions)")
    public void userValidatesThatTheHasThisDivisions(String attribute, String divisionId) {
        assertThat(response
                .getBody()
                .jsonPath()
                .get(attribute), hasItem(Integer.valueOf(divisionId)));
    }
}