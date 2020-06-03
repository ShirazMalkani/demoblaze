package po;

import locator.LoginPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final LoginPageLocator locator;
    private final String url = "https://www.ishopping.pk/customer/account/login";

    public LoginPage(LoginPageLocator locator) {
        this.locator = locator;
    }

    public void navigate() {
        this.locator.navigate(url);
    }

    public void login(String username, String password) throws Exception {
        this.locator.setValue("username", username);
        this.locator.setValue("password", password);
        this.locator.setValue("login", null);
    }

    // by = className, value = "hello" -> successful login case
    public WebElement getLoginResult(String by, String value) throws Exception {
        return this.locator.getValue(by, value);
    }

    public void logout() {
        this.locator.logout();
    }
}
