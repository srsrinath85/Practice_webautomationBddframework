package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.ConfigLoader;

public class MyStepdefs {
    public TestContext testContext;
    public ConfigLoader configLoader;
    public WebDriver driver;
    public MyStepdefs(TestContext testContext){
        this.testContext=testContext;
        this.configLoader=testContext.configLoader;
        this.driver=testContext.driver;
    }

    @Given("I open the browser")
    public void iOpenTheBrowser() {
       driver.get(configLoader.getProperty("url"));
    }
}
