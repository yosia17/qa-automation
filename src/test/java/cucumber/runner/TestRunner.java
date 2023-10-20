package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumber/resource/features",
        glue = "cucumber.stepDef",
        plugin = {"pretty","html:src/test/report.html"}
)

public class TestRunner {
}
