package heap.aa9b.one;

import org.junit.jupiter.api.Test;

/// facets:
/// - patterns
/// - listener
class ListenerEntryPointTest
{
    @Test
    void exercise_reverse_engineering_design()
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