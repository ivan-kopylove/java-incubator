package heap.ad2e;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// functional interface playground
import heap.qweqweweqweq.TestBase;
class ExampleTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {
        LambdaInterface lambdaInterface = (str, num) -> {
            System.out.println("Lambda function");
            return 2L;
        };

        assertEquals(2L, lambdaInterface.doSomething("str", 5));
    }

    @Test
    void exercise_design_reverse_engineering01()
    {
        LambdaInterface lambdaInterface = (str, num) -> {
            System.out.println("Lambda function");
            return 2L;
        };

        assertEquals(0, lambdaInterface.someDefaultMethod());
    }

    @Test
    void exercise_design_reverse_engineering02()
    {

        LambdaInterface lambdaInterface = new LambdaInterface2Impl();

        assertEquals(1, lambdaInterface.someDefaultMethod());
    }
}
