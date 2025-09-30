package named.concurrencyBasic01;

import org.junit.jupiter.api.Test;

public class BasicThreadCreation
{

    @Test
    void exercise_design_reverse_engineering() throws InterruptedException
    {
        Thread thread = new Thread(() -> {
            System.out.println("Thread execution: " + Thread.currentThread().getName());
        });

        /// What is the state of the thread here? (BEFORE start())
        thread.start();

        /// What is the state here? (AFTER start())
        System.out.println("Main execution: " + Thread.currentThread().getName());
        thread.join(); // what does join do? what if I drop the join? why join named like this?
    }
}