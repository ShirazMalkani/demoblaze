package tests;

import configuration.UserWebDriver;
import dal.ShirazTest;
import locator.LoginPageLocator;
import lombok.extern.slf4j.Slf4j;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;
import po.LoginPage;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@Slf4j
@Category(ShirazTest.class)
public class LoginPageTests {

    private static LoginPage loginPage;

    static {
        try {
            loginPage = new LoginPage(new LoginPageLocator(UserWebDriver.getInstance("chrome")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/login.csv", numLinesToSkip = 1)
    public void loginTest(String username, String password, String locator,
                          String locatorValue, String expected, Boolean isSuccessfulLogin) throws Exception {
        log.info("Running test Login with username {} and password {}", username, password);

        if(null == username) {
            username = "";
        }
        if(null == password) {
            password = "";
        }

        this.loginPage.navigate();
        this.loginPage.login(username, password);
        WebElement loginResult = this.loginPage.getResult(locator, locatorValue);

        assertEquals(expected, loginResult.getText());

        if(isSuccessfulLogin)
            this.loginPage.logout();
    }
}
