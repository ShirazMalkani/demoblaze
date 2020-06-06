package dal;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.LoginPageTest;
import tests.MyAccountPageTest;
import tests.RegistrationPageTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(ShirazTest.class)
@Suite.SuiteClasses({LoginPageTest.class, RegistrationPageTest.class, MyAccountPageTest.class, DemoTestCategory.class})
public class CategoryTestRunner {
}
