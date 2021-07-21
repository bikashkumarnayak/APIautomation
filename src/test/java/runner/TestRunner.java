package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\main\\resource\\featurefile", glue = { "stepDefinations" }, plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "html:target/Myreport/cucumber.html",
		"json:target/Myreport/cucumber.json", "junit:target/Myreport/cucumber.xml",
		"timeline:test-output-thread/" },   
        tags = "@AddPlace", 
        dryRun = false,
        monochrome = true, 
        strict = true, 
        publish = true)

public class TestRunner {

}
