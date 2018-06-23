package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		features = "src/test/java/feature",
		glue = {"stepdefinition"}
//		tags = "",
//		plugin = {"pretty", "html:target/cucumber-html-report"}
		)

public class TestRun extends AbstractTestNGCucumberTests {
	
//	 

}
