package po;

import bo.MyAccountBo;
import locator.BasePageLocator;
import org.jetbrains.annotations.NotNull;

public class MyAccountPage extends BasePage {

    private final String url = "https://www.ishopping.pk/customer/account";

    public MyAccountPage(BasePageLocator locator) {
        super(locator);
    }

    public void navigate() throws Exception {
        this.locator.navigate(url);
        this.locator.setValue("account_settings", null);
    }

    public void updateMyAccountDetails(@NotNull MyAccountBo myAccountBo) throws Exception {
        this.locator.setValue("firstname", myAccountBo.getFirstname());
        this.locator.setValue("lastname", myAccountBo.getLastname());
        this.locator.setValue("email", myAccountBo.getEmailAddress());

        if (myAccountBo.getChangePassword().equals("true")) {
            this.locator.setValue("change_password", null);
            this.locator.setValue("current_password", myAccountBo.getPassword());
            this.locator.setValue("new_password", myAccountBo.getUpdatedPassword());
            this.locator.setValue("confirm_new_password", myAccountBo.getConfirmedUpdatedPassword());
        }
        this.locator.setValue("save", null);
    }

//    onClickAccountSettingsShouldOpenAccountSettingsPage

}
