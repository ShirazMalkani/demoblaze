package dal;

import bo.Login;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(ShirazTest.class)
@Suite.SuiteClasses({DemoTestCategory.class, Login.class})
public class CategoryTestRunner {
}
