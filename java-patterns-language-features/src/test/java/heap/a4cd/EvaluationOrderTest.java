package heap.a4cd;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

class EvaluationOrderTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering1()
    {
        int x = 5;
        int y = 10;
        int result = ++x * y--;
        //        assertEquals(, myResultField);
    }

    @Test
    void exercise_design_reverse_engineering2()
    {
        String result1 = "1 + 2 = " + 1 + 2;
        String result2 = "1 + 2 = " + (1 + 2);


        //        System.out.println(result1);
        //        System.out.println(result2);
    }

    @Test
    void exercise_design_reverse_engineering4()
    {
        String result1 = 1 + 2 + "abc";
        String result2 = "abc" + 1 + 2;


        //        System.out.println(result1);
        //        System.out.println(result2);
    }

    @Test
    void exercise_design_reverse_engineering3()
    {
        int year = 2020;
        boolean result = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

        System.out.println(result);
    }
}
