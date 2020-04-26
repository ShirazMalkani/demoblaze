package bo;

import configuration.SeleniumConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@Slf4j // logging
@SpringBootTest
@RunWith(SpringRunner.class)

public class Home {
    private static SeleniumConfig seleniumConfig;

    private static WebDriver driver;

    @Value("${url.login:https://www.demoblaze.com/}")
    private String loginUrl;

    //@Ignore
    @Test
    public void demotest() {
        assert true;
    }

    @BeforeClass
    public static void setup() throws IOException {
        log.info("setup() function called");
        seleniumConfig = new SeleniumConfig();
        seleniumConfig.setupDriver();
        driver = seleniumConfig.getDriver();
    }

    @Before
    public void setDriver()
    {
        log.info("setDriver() function called");
    }

    private void setURL(String url) {
        driver.get(url);
    }

    //@Ignore
    @Test
    public void NavBarContent() {
    }

    //@Ignore
    @Test
    public void OnSuccessfulContentLoad() {
    }

    //@Ignore
    @Test
    public void OnClickNavContent() {
    }

    //@Ignore
    @Test
    public void OnAddToCart() {
    }

    //@Ignore
    @Test
    public void OnOrderRequest() {
    }

    //@Ignore
    @Test
    public void OnSearch() {
    }

    @After
    public void afterTest() {
    }

    private void closeCurrentTabAndOpenNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('','_blank');");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }

    @AfterClass
    public static void closeAllOpenedTabs() {
        for(String str: new ArrayList<>(driver.getWindowHandles())) {
            driver.switchTo().window(str).close();
        }
    }
}
