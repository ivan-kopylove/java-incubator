package heap.ad2e;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// functional interface playground
class ExampleTest
{
    @Test
    void reverse_engineer_hypothetical_design()
    {
        LambdaInterface lambdaInterface = (str, num) -> {
            System.out.println("Lambda function");
            return 2L;
        };

        assertEquals(2L, lambdaInterface.doSomething("str", 5));
    }

    @Test
    void reverse_engineer_hypothetical_design01()
    {
        LambdaInterface lambdaInterface = (str, num) -> {
            System.out.println("Lambda function");
            return 2L;
        };

        assertEquals(0, lambdaInterface.someDefaultMethod());
    }

    @Test
    void reverse_engineer_hypothetical_design02()
    {

        LambdaInterface lambdaInterface = new LambdaInterface2Impl();

        assertEquals(1, lambdaInterface.someDefaultMethod());
    }
}
