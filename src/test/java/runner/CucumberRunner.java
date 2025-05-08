package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"Steps", "Hooks"},
    plugin = {
        "pretty","html:target/cucumber-reports.html",
              "json:target/cucumber-reports.json",
              "junit:target/cucumber-reports.xml",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    }
)
public class CucumberRunner extends AbstractTestNGCucumberTests{
    
}
