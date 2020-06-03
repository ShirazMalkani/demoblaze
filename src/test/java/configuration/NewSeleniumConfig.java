package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NewSeleniumConfig {

    public WebDriver driver() throws IOException {

        String driverFile = PropertiesLoader.loadProperties("application.properties").getProperty("selenium.chromedriver");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(driverFile))
                .build();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");                                               // Bypass OS security model, MUST BE THE VERY FIRST OPTION
        options.setExperimentalOption("useAutomationExtension", false);
        // options.addArguments("start-maximized");                                         // open Browser in maximized mode
        options.addArguments("--disable-infobars");                                         // disabling infobars
        options.addArguments("--disable-browser-side-navigation");                          // disabling
        options.addArguments("--disable-extensions");                                       // disabling extensions
        options.addArguments("--disable-gpu");                                              // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage");                                    // overcome limited resource problems
        ChromeDriver driver = new ChromeDriver(service, options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
