package named.variance;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Step50ExtendsTest extends TestBase
{
    @Test
    void test1()
    {
        List<Integer> ints = Arrays.asList(1, 2);
        //        List<? extends Number> nums1 = ints;
        //        List<? super Number> nums2 = ints;
    }

    void test2()
    {
        List<? extends Apple> apples = new ArrayList<>();
        //        apples.add(null);
        //        apples.add(new Object());
        //        apples.add(new Fruit());
        //        apples.add(new Apple());
        //        apples.add(new Orange());
        //        apples.add(new Jonathan());
    }

    void test3(List<? extends Apple> apples)
    {
        //         apples.add(null);
        //         apples.add(new Object());
        //         apples.add(new Fruit());
        //         apples.add(new Apple());
        //         apples.add(new Orange());
        //         apples.add(new Jonathan());
    }
}
