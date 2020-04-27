package bo;

import configuration.SeleniumConfig;
import dal.ShirazTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.experimental.categories.Category;
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
@Category(ShirazTest.class)
@RunWith(SpringRunner.class)
public class Login {
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
    public void loginWithoutUsernameTest() {
        log.info("Running testLoginWithCorrectUserNameAndCorrectPassword");
        setURL(loginUrl);

        WebElement myAccount = driver.findElement(By.className("first"));
        myAccount.click();

        driver.findElement(By.id("account_al_auth_login_email")).sendKeys("");
        driver.findElement(By.id("account_al_auth_login_password")).sendKeys("shirazatdsu@gmail.com");

        driver.findElement(By.id("send2")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement validationAdviceMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("advice-required-entry-account_al_auth_login_email")));

        assertEquals("This is a required field.", validationAdviceMessage.getText());
    }

    //@Ignore
    @Test
    public void loginWithoutPasswordTest() {
        log.info("Running testLoginWithCorrectUserNameAndCorrectPassword");
        setURL(loginUrl);

        WebElement myAccount = driver.findElement(By.className("first"));
        myAccount.click();

        driver.findElement(By.id("account_al_auth_login_email")).sendKeys("shirazatdsu@gmail.com");
        driver.findElement(By.id("account_al_auth_login_password")).sendKeys("");

        driver.findElement(By.id("send2")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement validationAdviceMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("advice-required-entry-account_al_auth_login_password")));

        assertEquals("This is a required field.", validationAdviceMessage.getText());
    }

    //@Ignore
    @Test
    public void validLoginTest() {
        log.info("Running testLoginWithCorrectUserNameAndCorrectPassword");
        setURL(loginUrl);

        WebElement myAccount = driver.findElement(By.className("first"));
        myAccount.click();

        driver.findElement(By.id("account_al_auth_login_email")).sendKeys("shirazatdsu@gmail.com");
        driver.findElement(By.id("account_al_auth_login_password")).sendKeys("shirazatdsu@gmail.com");

        driver.findElement(By.id("send2")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement helloMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("hello")));

        assertEquals("Hello, Shiraz Malkani!", helloMessage.getText());
        logoutFromAccount();
    }

    //@Ignore
    @Test
    public void invalidUsernameTest() {
        log.info("Running testLoginWithCorrectUserNameAndCorrectPassword");
        setURL(loginUrl);
//        System.out.println(driver.getCurrentUrl());
        WebElement myAccount = driver.findElement(By.className("first"));
        myAccount.click();

        driver.findElement(By.id("account_al_auth_login_email")).sendKeys("abc");
        driver.findElement(By.id("account_al_auth_login_password")).sendKeys("shirazatdsu@gmail.com");

        driver.findElement(By.id("send2")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement validationAdviceMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("advice-validate-email-account_al_auth_login_email")));

        assertEquals("Please enter a valid email address. For example johndoe@domain.com.", validationAdviceMessage.getText());
    }

    //@Ignore
    @Test
    public void validUsernameInvalidPasswordTest() {
        log.info("Running testLoginWithCorrectUserNameAndCorrectPassword");
        setURL(loginUrl);

        WebElement myAccount = driver.findElement(By.className("first"));
        myAccount.click();

        driver.findElement(By.id("account_al_auth_login_email")).sendKeys("shirazatdsu@gmail.com");
        driver.findElement(By.id("account_al_auth_login_password")).sendKeys("abc");

        driver.findElement(By.id("send2")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement validationAdviceMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("advice-validate-password-account_al_auth_login_password")));

        assertEquals("Please enter 6 or more characters. Leading or trailing spaces will be ignored.", validationAdviceMessage.getText());
    }

    //@Ignore
    @Test
    public void wrongUsernamePasswordTest() {
        log.info("Running testLoginWithCorrectUserNameAndCorrectPassword");
        setURL(loginUrl);

        WebElement myAccount = driver.findElement(By.className("first"));
        myAccount.click();

        driver.findElement(By.id("account_al_auth_login_email")).sendKeys("abc@def.ghi");
        driver.findElement(By.id("account_al_auth_login_password")).sendKeys("shirazatdsu@gmail.com");

        driver.findElement(By.id("send2")).click();
        String Xpath= "//*[@class='error-msg']/ul/li";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement invalidUsernameOrPasswordMessage =   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));

        assertEquals("Invalid login or password.", invalidUsernameOrPasswordMessage.getText());
    }

    @After
    public void afterTest() {
    }

    private void logoutFromAccount() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement helloMessage =   wait.until(ExpectedConditions.presenceOfElementLocated(By.className("hello")));
            if("Hello, Shiraz Malkani!".equals(helloMessage.getText())) {
                driver.findElement(By.linkText("Log Out")).click();
            }
        }
        catch (NoSuchElementException noSuchElementException) {
            System.out.println("Here in NoSuchElementException exception from logoutFromAccount");
        }
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
