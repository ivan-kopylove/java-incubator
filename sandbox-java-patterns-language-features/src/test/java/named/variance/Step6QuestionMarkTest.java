package named.variance;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/// Answer the questions stated in [Fruit].
class Step6QuestionMarkTest
{
    @Test
    void test1()
    {
        //            List<Integer> ints = Arrays.asList(1, 2);
        //            List<?> nums = ints;
    }

    void test2()
    {
        List<?> apples = new ArrayList<>();
        //        apples.add(null);
        // apples.add(new Object());
        // apples.add(new Fruit());
        // apples.add(new Apple());
        // apples.add(new Orange());
        // apples.add(new Jonathan());
    }

    void test3(List<?> apples)
    {
        //        apples.add(null);
        // apples.add(new Object());
        // apples.add(new Fruit());
        // apples.add(new Apple());
        // apples.add(new Orange());
        // apples.add(new Jonathan());
    }
}
