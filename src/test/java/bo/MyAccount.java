package bo;

import configuration.SeleniumConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;

@Slf4j // logging
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyAccount {

    private static SeleniumConfig seleniumConfig;

    private static WebDriver driver;

    @Value("${url.login:https://www.ishopping.pk/}")
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
    public void onClickAccountSettingsShouldOpenAccountSettingsPage() {
    }

    //@Ignore
    @Test
    public void onClickShippingAddressesShouldOpenShippingAddressesPage() {
    }

    //@Ignore
    @Test
    public void onClickMyOrdersShouldOpenMyOrdersPage() {
    }

    //@Ignore
    @Test
    public void onClickProductsReviewShouldOpenProductsReviewPage() {
    }

    //@Ignore
    @Test
    public void onClickWishListShouldOpenWishListPage() {
    }

    //@Ignore
    @Test
    public void onClickLogoutShouldLogoutUser() {
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
