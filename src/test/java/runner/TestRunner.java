package runner;

import static java.util.Objects.requireNonNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = { "scenarios",
                "hooks" }, features = "src/test/java/scenarios")
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setupBeforeClass() {
        requireNonNull("D:\\veera project\\Intellij_Workspace\\ui-tests-automation\\src\\test\\resources\\devconfig.propertiesdevconfig.properties",
                "credentials file not provided");
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
