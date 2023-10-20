package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "cucumber/resource/features",
        glue = "cucumber/stepDef",
        plugin = {"html:target/Html_report.html"}
)

public class Runner {
}
