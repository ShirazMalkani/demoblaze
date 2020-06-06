package tests;

import bo.RegistrationBo;
import configuration.UserWebDriver;
import locator.RegistrationPageLocator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;
import po.RegistrationPage;
import utilities.RegistrationAggregator;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@Tag("Registration")
public class RegistrationPageTest extends BaseTest {

    private static RegistrationPage registrationPage;

    static {
        try {
            registrationPage = new RegistrationPage(new RegistrationPageLocator(UserWebDriver.getInstance("chrome")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/register.csv", numLinesToSkip = 1)
    public void registerTest(@AggregateWith(RegistrationAggregator.class) RegistrationBo registrationBo) throws Exception {
        log.info("Running registerTest with data {}", registrationBo.toString());

        this.registrationPage.navigate();
        this.registrationPage.accountDetails(registrationBo);

        WebElement registerResult = this.registrationPage.getResult(registrationBo.getLocator(), registrationBo.getLocatorValue());
        assertEquals(registrationBo.getExpectedOutput(), registerResult.getText());
    }
}
