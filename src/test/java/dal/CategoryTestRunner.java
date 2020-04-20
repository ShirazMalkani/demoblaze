package dal;

import bo.DemoTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(ShirazTest.class)
@Suite.SuiteClasses({DemoTestCategory.class, DemoTest.class})
public class CategoryTestRunner {
}
