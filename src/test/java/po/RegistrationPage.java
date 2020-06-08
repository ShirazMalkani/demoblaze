package po;

import bo.RegistrationBo;
import locator.BasePageLocator;
import org.jetbrains.annotations.NotNull;

public class RegistrationPage extends BasePage {

    private final String url = "https://www.ishopping.pk/customer/account/create/";

    public RegistrationPage(BasePageLocator locator) {
        super(locator);
    }

    @Override
    public void navigate() {
        this.locator.navigate(url);
    }

    public void accountDetails(@NotNull RegistrationBo registrationBo) throws Exception {
        this.locator.setValue("firstname", registrationBo.getFirstname());
        this.locator.setValue("lastname", registrationBo.getLastname());
        this.locator.setValue("email", registrationBo.getEmailAddress());
        this.locator.setValue("password", registrationBo.getPassword());
        this.locator.setValue("confirmPassword", registrationBo.getConfirmPassword());

        if (registrationBo.getSignupForNewsletter().equals("true")) {
            this.locator.setValue("news_letter_subscribe", null);
        }
        this.locator.setValue("register", null);
    }
}
