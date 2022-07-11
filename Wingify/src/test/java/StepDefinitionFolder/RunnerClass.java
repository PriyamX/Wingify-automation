package StepDefinitionFolder;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/Features", glue = { "StepDefinitionFolder" }, monochrome = true,

		plugin = { "pretty", "json:target/JSONReports/report.json", "html:target/HtmlReports",
				"junit:target/JUnitReports/report.xml" }, tags = "@WingifyHeatmap")

public class RunnerClass {

}
