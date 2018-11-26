package web.test;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(tags= {"@create,@update"},features = "src/test/resources/features")
public class ApplicationTestRunner {
}