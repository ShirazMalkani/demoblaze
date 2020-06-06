package tests;

import bo.LoginBo;
import configuration.UserWebDriver;
import locator.LoginPageLocator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;
import po.LoginPage;
import utilities.LoginAggregator;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@Slf4j
@Tag("Login")
public class LoginPageTest extends BaseTest {

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
    public void loginTest(@AggregateWith(LoginAggregator.class) LoginBo loginBo) throws Exception {
        log.info("Running test Login with data {}", loginBo.toString());

        if(null == loginBo.getUsername()) {
            loginBo.setUsername("");
        }
        if(null == loginBo.getPassword()) {
            loginBo.setPassword("");
        }

        this.loginPage.navigate();
        this.loginPage.login(loginBo.getUsername(), loginBo.getPassword());
        WebElement loginResult = this.loginPage.getResult(loginBo.getLocator(), loginBo.getLocatorValue());

        assertEquals(loginBo.getExpected(), loginResult.getText());

        if(loginBo.getIsSuccessfulLogin().equals("true"))
            this.loginPage.logout();
    }
}
