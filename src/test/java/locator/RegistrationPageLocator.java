package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageLocator extends BasePageLocator{

    public RegistrationPageLocator(WebDriver browser) {
        super(browser);
    }

    @Override
    public void setValue(String element, String value) throws Exception {
        if(null == value) {
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
                webElement = locate(new By.ById("email_address"));
                webElement.clear();
                webElement.sendKeys(value);
                break;
            case "password":
                webElement = locate(new By.ById("password"));
                webElement.clear();
                webElement.sendKeys(value);
                break;
            case "confirmPassword":
                webElement = locate(new By.ById("confirmation"));
                webElement.clear();
                webElement.sendKeys(value);
                break;
            case "news_letter_subscribe":
                webElement = locate(new By.ById("is_subscribed"));
                webElement.sendKeys(Keys.SPACE);
                break;
            case "register":
                locate(new By.ByXPath("//span[.='Register']")).click();
                break;
            default:
                throw new Exception("Not implemented exception for element option " + element);
        }
    }
}
