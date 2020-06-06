package po;

import locator.BasePageLocator;
import org.openqa.selenium.WebElement;

public class BasePage {

    final BasePageLocator locator;

    public BasePage(BasePageLocator locator) {
        this.locator = locator;
    }

    // by = className, value = "hello" -> successful login case
    public WebElement getResult(String by, String value) throws Exception {
        return this.locator.getValue(by, value);
    }

    public void logout() {
        this.locator.logout();
    }

    public void login(String emailAddress, String password) throws Exception {
        locator.login(emailAddress, password);
    }
}
