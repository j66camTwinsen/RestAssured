package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"},
        glue = {"steps"},
        plugin = {"json:test/report/cucumber_report.json"},
        monochrome = true,
        tags = "@API5"
)

public class TestRunner {

}
