package heap.a4cd;

import org.junit.jupiter.api.Test;

/**
 * aka Operator p______
 */
class EvaluationOrderTest
{
    @Test
    void calculateYourselfFirst1()
    {
        int x = 5;
        int y = 10;
        int result = ++x * y--;
        //        assertEquals(, myResultField);
    }

    @Test
    void calculateYourselfFirst2()
    {
        String result1 = "1 + 2 = " + 1 + 2;
        String result2 = "1 + 2 = " + (1 + 2);


        //        System.out.println(result1);
        //        System.out.println(result2);
    }

    @Test
    void calculateYourselfFirst4()
    {
        String result1 = 1 + 2 + "abc";
        String result2 = "abc" + 1 + 2;


        //        System.out.println(result1);
        //        System.out.println(result2);
    }

    @Test
    void calculateYourselfFirst3()
    {
        int year = 2020;
        boolean result = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

        System.out.println(result);
    }
}
