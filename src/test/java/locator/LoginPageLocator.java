package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPageLocator {

    private final WebDriver browser;

    public LoginPageLocator(WebDriver browser) {
        this.browser = browser;
    }

    public void navigate(String url) {
        this.browser.navigate().to(url);
    }

    public void setValue(String element, String value) throws Exception {
        switch (element) {
            case "username" :
                locate(new By.ById("account_al_auth_login_email")).sendKeys(value);
                break;
            case "password" :
                locate(new By.ById("account_al_auth_login_password")).sendKeys(value);
                break;
            case "login" :
                locate(new By.ById("send2")).click();
                break;
            default:
                throw new Exception("Not implemented exception for element option " + element);
        }
    }

    public WebElement getValue(String by, String value) throws Exception {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(20));
        switch (by) {
            case "id":
                return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
            case "className":
                return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(value)));
            case "name":
                return wait.until(ExpectedConditions.presenceOfElementLocated(By.name(value)));
            case "xpath":
                return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
            default:
                throw new Exception("Not implemented exception for by option " + by);
        }
    }

    private WebElement locate(By type) {
        return this.browser.findElement(type);
    }

    public void logout() {
        locate(new By.ByLinkText("Log Out")).click();
    }
}
