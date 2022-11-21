package steps;

import io.cucumber.java.Before;
import utilities.APIUtilities;

public class TestInitialize {

    @Before
    public void testSetUp() {
        APIUtilities APIUtilities = new APIUtilities();
    }

}
