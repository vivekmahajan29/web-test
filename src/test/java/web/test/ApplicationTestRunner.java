package web.test;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
// tags= {"@create,@update"},
@CucumberOptions(features = "src/test/resources/features")
public class ApplicationTestRunner {
}