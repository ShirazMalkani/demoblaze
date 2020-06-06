package po;

import locator.BasePageLocator;

public class LoginPage extends BasePage {

    private final String url = "https://www.ishopping.pk/customer/account/login";

    public LoginPage(BasePageLocator locator) {
        super(locator);
    }

    public void navigate() {
        this.locator.navigate(url);
    }

    public void login(String username, String password) throws Exception {
        this.locator.setValue("username", username);
        this.locator.setValue("password", password);
        this.locator.setValue("login", null);
    }

}
