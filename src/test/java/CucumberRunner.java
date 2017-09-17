import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by user on 14.09.2017.
 */
    @RunWith(Cucumber.class)
    @CucumberOptions(features = {"src/test/resourses/"}, glue = {"steps"},
            plugin = {
                    "util.AllureReporter",
            }
    )
    public class CucumberRunner {

    }

