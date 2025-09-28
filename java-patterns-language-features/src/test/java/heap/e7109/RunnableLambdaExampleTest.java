package heap.e7109;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.fail;

import com.github.ivan.kopylove.commons.testing.TestBase;
class RunnableLambdaExampleTest extends TestBase
{

    @Test
    void exercise_design_reverse_engineering()
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
        Consumer r3 = (a) -> System.out.println("runnable 2");
        MyInterface r4 = () -> System.out.println("runnable 4");

        r1.run();
        r2.run();
        r3.accept("something");
        r4.myMethod();



        //                new Thread(r1);// is that compilable?
        //                new Thread(r2);// is that compilable?
        //                new Thread(r3);// is that compilable?
        //                new Thread(r4);// is that compilable?
    }
}
