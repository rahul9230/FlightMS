package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features/DeleteSchedule.feature",glue= {"stepDefinition"})
//plugin= {"pretty","html:test-output","json:json_ouput/cucumber-report","junit:junit_xml/cucumber.xml"},monochrome=true)

public class TestRunner {
	
}