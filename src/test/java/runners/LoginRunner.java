package runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\features\\Login.feature", glue = {
		"steps" }, dryRun = false, monochrome = true, plugin = { "pretty", "html:test-output" })
public class LoginRunner {
}
