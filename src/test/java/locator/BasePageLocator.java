package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageLocator {
    final WebDriver browser;

    public BasePageLocator(WebDriver browser) {
        this.browser = browser;
    }

    public void navigate(String url) {
        this.browser.navigate().to(url);
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

    public void setValue(String element, String value) throws Exception{}

    public WebElement locate(By type) {
        return this.browser.findElement(type);
    }

    public void login(String email, String password) {
        navigate("https://www.ishopping.pk/customer/account/login");
        locate(new By.ById("account_al_auth_login_email")).sendKeys(email);
        locate(new By.ById("account_al_auth_login_password")).sendKeys(password);
        locate(new By.ById("send2")).click();
    }

    public void logout() {
        locate(new By.ByLinkText("Log Out")).click();
    }
}
