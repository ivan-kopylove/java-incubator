package inbox.qwewqeqwe123;

import org.junit.jupiter.api.Test;

public class ThreadBasics {

    /**
     * 1. What will the output look like if we run this code?
     * 2. How many threads are executing here?
     * 3. Why does the output vary between runs?
     */
    @Test
    void demonstrateSequentialVsConcurrent() throws InterruptedException {
        // Sequential execution
        System.out.println("Sequential start:");
        task("A");
        task("B");
        
        // Concurrent execution
        System.out.println("Concurrent start:");
        Thread thread1 = new Thread(() -> task("C"));
        Thread thread2 = new Thread(() -> task("D"));
        thread1.start();
        thread2.start();

        // what if I drop both joins? why the method is called join?
        thread1.join();
        thread2.join();
    }
    
    private void task(String name) {
        for (int i = 0; i < 3; i++) {
            System.out.println(name + ": " + i);
        }
    }
}