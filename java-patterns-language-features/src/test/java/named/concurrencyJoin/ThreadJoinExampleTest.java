package named.concurrencyJoin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import com.github.ivan.kopylove.commons.testing.TestBase;
class ThreadJoinExampleTest extends TestBase
{
    @Test
    @DisplayName("run the example and explain the behaviour")
    void should_print_one_by_one_ascending() throws InterruptedException
    {
        for (int i = 0; i < 10; i++)
        {
            int a = i;
            Thread thread = new Thread(() -> {
                System.out.println(a);
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
            });
            //                thread.join(); // try different combinations of comment-uncomment
            thread.start();
            // what is in common to fork-join here?
            thread.join(); // try different combinations of comment-uncomment
        }

        System.out.println("main thread");
    }
}