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
    protected String locator;
    protected String locatorValue;
    protected String expectedOutput;
}
