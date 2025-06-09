package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"Steps","Hooks"},
        plugin = {"pretty"},
        tags = " @All")

public class CucumberRunner extends AbstractTestNGCucumberTests {

}

