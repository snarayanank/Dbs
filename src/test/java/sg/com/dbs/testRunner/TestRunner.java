package sg.com.dbs.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/sg/com/dbs/features",
        glue = {"sg/com/dbs/stepDefinitions"},
        plugin= {"pretty",
        "html:target/site/cucumber-report.html",
        "json:target/cucumber.json"},
        monochrome = true//,
        //tags = "@RegressionTest and @SmokeTest"
        )

public class TestRunner {

}