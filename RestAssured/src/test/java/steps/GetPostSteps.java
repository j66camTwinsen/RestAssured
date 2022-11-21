package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.APIUtilities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class GetPostSteps {

    public ResponseOptions<Response> response;

    @Given("User performs GET operation for {string}")
    public void userPerformsGETOperationFor(String resource) {
        response = APIUtilities.get(resource);
    }

    @Then("User validates that in the {string} this {string} exists")
    public void userValidatesThatInTheThisExists(String authorAttribute, String authorValue) {
        assertThat(response
                .getBody()
                .jsonPath()
                .get(authorAttribute), hasItem(authorValue));
    }

    @Then("User validates that a collection of {string} exists")
    public void userValidatesThatACollectionOfExists(String arg0) {
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
}
