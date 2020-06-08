package bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationBo {
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String password;
    private String confirmPassword;
    private String signupForNewsletter;
    private String locator;
    private String locatorValue;
    private String expectedOutput;
}
