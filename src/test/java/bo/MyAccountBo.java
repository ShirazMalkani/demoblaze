package bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyAccountBo {
    private String currentEmailAddress;
    private String currentPassword;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String changePassword;
    private String password;
    private String updatedPassword;
    private String confirmedUpdatedPassword;
    private String locator;
    private String locatorValue;
    private String expectedOutput;
}
