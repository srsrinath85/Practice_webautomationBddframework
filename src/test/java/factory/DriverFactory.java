package factory;

import constants.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class DriverFactory {

    public static WebDriver initializeDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser", String.valueOf(Browser.FIREFOX));

        switch (Browser.valueOf(browser.toUpperCase())) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                // chromeOptions.addArguments("--remote-allow-origins=*");
//                if (System.getProperty("browserMode", "normal").equalsIgnoreCase("headless")) {
//                    // chromeOptions.addArguments("--headless");
//                    chromeOptions.addArguments("window-size=1920,1080");
//                }
//                if (System.getProperty("debugMode", "false").equalsIgnoreCase("true"))
//                    chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);

            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                if (System.getProperty("browserMode", "normal").equalsIgnoreCase("headless")) {
//                    firefoxOptions.addArguments("--headless");
//                }

                firefoxOptions.addArguments("-private");
                driver = new FirefoxDriver(firefoxOptions);
            }
            default -> throw new RuntimeException("Invalid Browser: " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }
}
