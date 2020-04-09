package com.test.liferay.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/test/liferay/feature", glue = {"com.test.liferay.glue"})
public class SubmitFormTestRunner {

}
