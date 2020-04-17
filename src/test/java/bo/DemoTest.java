package bo;

import configuration.SeleniumConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoTest {

    private static SeleniumConfig seleniumConfig;
    private static WebDriver driver;

    @Value("${url.login:https://www.demoblaze.com/}")
    private String loginUrl;

    @BeforeClass
    public static void setup() throws IOException {
        log.info("setup() function called");
        seleniumConfig = new SeleniumConfig();
    }

    @Before
    public void setDriver()
    {
        log.info("setDriver() function called");
        seleniumConfig.setupDriver();
        driver = seleniumConfig.getDriver();
    }

    private void setURL(String url) {
        driver.get(url);
    }

    @Test
    public void demotest() {
        assert true;
    }

    @Test
    public void validLoginTest() {
        log.info("Running testLoginWithCorrectUserNameAndCorrectPassword");
        setURL(loginUrl);
        System.out.println(driver.getCurrentUrl());
        WebElement myAccount = driver.findElement(By.className("first"));
        myAccount.click();

        driver.findElement(By.id("account_al_auth_login_email")).sendKeys("shirazatdsu@gmail.com");
        driver.findElement(By.id("account_al_auth_login_password")).sendKeys("shirazatdsu@gmail.com");

        driver.findElement(By.id("send2")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement helloMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("hello")));

        assertEquals("Hello, Shiraz Malkani!", helloMessage.getText());
//        WebElement userNameElement = driver.findElement(By.id("username"));
//        WebElement passwordElement = driver.findElement(By.id("password"));

    }
}
