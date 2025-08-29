package heap.a7d5;

import org.junit.jupiter.api.Test;

class RunnableLambdaExampleTest
{

    @Test
    void an_example_of_what()
    {
        Runnable r1 = new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("runnable 1");
            }
        };

        Runnable r2 = () -> System.out.println("runnable 2");
        r1.run();
        r2.run();
    }
}
