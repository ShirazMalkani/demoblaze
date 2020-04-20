package dal;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(ShirazTest.class)
public class DemoTestCategory {

    @Test
    public void test01() {
        assert true;
    }

    @Test
    public void test02() {
        assert !false;
    }
}
