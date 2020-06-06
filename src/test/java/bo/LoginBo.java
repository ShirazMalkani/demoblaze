package bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginBo {
    private String username;
    private String password;
    private String isSuccessfulLogin;
    private String locator;
    private String locatorValue;
    private String expected;
}
