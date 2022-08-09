package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/features/steps.feature",
        glue = {"stepDefinitions"}
)
public class RunTest extends AbstractTestNGCucumberTests {

}
