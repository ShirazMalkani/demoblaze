package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPageLocator extends BasePageLocator {

    public MyAccountPageLocator(WebDriver browser) {
        super(browser);
    }

    @Override
    public void setValue(String element, String value) throws Exception {
        if (null == value) {
            value = "";
        }
        WebElement webElement = null;
        switch (element) {
            case "firstname":
                webElement = locate(new By.ById("firstname"));
                webElement.clear();
                webElement.sendKeys(value);
                break;
            case "lastname":
                webElement = locate(new By.ById("lastname"));
                webElement.clear();
                webElement.sendKeys(value);
                break;
            case "email":
                webElement = locate(new By.ById("email"));
                webElement.clear();
                webElement.sendKeys(value);
                break;
            case "change_password":
                locate(new By.ById("change_password")).sendKeys(Keys.SPACE);
                break;
            case "current_password":
                webElement = locate(new By.ById("current_password"));
                webElement.clear();
                webElement.sendKeys(value);
                break;
            case "new_password":
                webElement = locate(new By.ById("password"));
                webElement.clear();
                webElement.sendKeys(value);
                break;
            case "confirm_new_password":
                webElement = locate(new By.ById("confirmation"));
                webElement.clear();
                webElement.sendKeys(value);
                break;
            case "save":
                locate(new By.ByXPath("//span[.='Save']")).click();
                break;
            case "account_settings":
                locate(new By.ByClassName("navigation-account_edit")).click();
                break;
            default:
                throw new Exception("Not implemented exception for element option " + element);
        }
    }
}
