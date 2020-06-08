package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageLocator extends BasePageLocator {

    public LoginPageLocator(WebDriver browser) {
        super(browser);
    }

    @Override
    public void setValue(String element, String value) throws Exception {
        switch (element) {
            case "username":
                locate(new By.ById("account_al_auth_login_email")).sendKeys(value);
                break;
            case "password":
                locate(new By.ById("account_al_auth_login_password")).sendKeys(value);
                break;
            case "login":
                locate(new By.ById("send2")).click();
                break;
            default:
                throw new Exception("Not implemented exception for element option " + element);
        }
    }
}
