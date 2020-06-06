package tests;

import bo.MyAccountBo;
import configuration.UserWebDriver;
import dal.ShirazTest;
import locator.MyAccountPageLocator;
import lombok.extern.slf4j.Slf4j;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;
import po.MyAccountPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
@Category(ShirazTest.class)
public class MyAccountPageTest extends BaseTest {

    private static MyAccountPage myAccountPage;

    static {
        try {
            myAccountPage = new MyAccountPage(new MyAccountPageLocator(UserWebDriver.getInstance("chrome")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/myaccount.csv", numLinesToSkip = 1)
    public void myAccountSettingsUpdateTest(@AggregateWith(MyAccountAggregator.class) MyAccountBo myAccountBo) throws Exception {
        log.info("Running myAccountSettingsUpdateTest with data {}", myAccountBo.toString());

        // todo: move login and logout from test case level to class level
        this.myAccountPage.login(myAccountBo.getCurrentEmailAddress(), myAccountBo.getCurrentPassword());

        this.myAccountPage.navigate();
        this.myAccountPage.updateMyAccountDetails(myAccountBo);
        WebElement updateResult = this.myAccountPage.getResult(myAccountBo.getLocator(), myAccountBo.getLocatorValue());
        assertEquals(myAccountBo.getExpectedOutput(), updateResult.getText());

        this.myAccountPage.logout();
    }
}
