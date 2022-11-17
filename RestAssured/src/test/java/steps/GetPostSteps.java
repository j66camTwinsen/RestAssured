package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetPostSteps {

    @Given("I perform GET operation for {string}")
    public void i_perform_get_operation_for(String url) {
    }

    @When("I perform GET for the post number {string}")
    public void i_perform_get_for_the_post_number(String postNumber) {
        BDDStyledMethod.simpleGetPost(postNumber);
    }

    @Then("I should see the author name as {string}")
    public void i_should_see_the_author_name_as(String string) {

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
