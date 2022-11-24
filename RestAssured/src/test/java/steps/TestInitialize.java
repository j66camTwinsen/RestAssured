package steps;

import io.cucumber.java.Before;
import utilities.APIUtilities;

public class TestInitialize {

    @Before
    public void setUp() {
        APIUtilities APIUtilities = new APIUtilities();
    }

}
