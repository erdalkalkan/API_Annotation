package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "rerun:target/failed_scenarios.txt",
                "json:target/reports/json/json-reports/cucumber.json",
                "html:target/reports/html/Hyrai_reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        features = "./src/test/resources/features",
        glue = {"stepDefinitions"},
        dryRun = false,
        tags = "@API"
)
public class Runner {
}