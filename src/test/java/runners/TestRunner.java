

package runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/functionalTest",
		glue = {"stepDefinitions"},
		plugin = { "pretty" ,  "junit:target/cucumber-reports/Cucumber.json" },
		monochrome = true
		)


public class TestRunner {

}
