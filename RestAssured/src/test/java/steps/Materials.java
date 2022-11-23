package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.APIUtilities;
import utilities.FetchEnvParamsValues;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class Materials {

    private ResponseOptions<Response> response;

    @Given("User sends a GET request to the endpoint \\(Materials)")
    public void userSendsAGETRequestToTheEndpointMaterials() {
        String resource = "/v2/divisions" + FetchEnvParamsValues.fetchParamValue("DIVISION_ID") + "/materials";
        response = APIUtilities.get(resource);
    }

    /*@Then("User validates that the {string} has this {string} \\(Materials)")
    public void userValidatesThatTheHasThisMaterials(String arg0, String arg1) {
        assertThat(response
                .getBody()
                .jsonPath()
                .get(attribute), hasItem(Integer.valueOf(divisionId)));
    }*/
}
