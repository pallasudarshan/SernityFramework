package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//mvn clean verify -DRunnerClass=CucumberTestSuite.java

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/PatientBanner/PatientBanner.feature"
},
        glue = { "stepDefinitions" },
        tags = "not @ignore",
        plugin = { "json:target/cucumber-reports/Cucumber.json" })

public class CucumberTestSuite {
}
