package heap.aa9b.one;

import org.junit.jupiter.api.Test;



/// - listener
import com.github.ivan.kopylove.commons.testing.TestBase;
class ListenerEntryPointTest extends TestBase
{
    @Test
    void exercise_design_reverse_engineering()
    {

        MyLongRunningTask myLongRunningTask = new MyLongRunningTask(new OnCompleteListener()
        {
            @Override
            public void onComplete()
            {
                System.out.println("Yeah, the long running task has been completed!");
            }
        });

        System.out.println("Starting the long running task.");
        myLongRunningTask.run();
    }
}