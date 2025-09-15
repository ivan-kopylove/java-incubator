package inbox.qwewqeqwe123;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VisibilityExample {
    private boolean flag = false; // Line C: Try with and without volatile

    public void toggleFlag() {
        flag = true; // Line D
    }

    public boolean getFlag() {
        return flag; // Line E
    }

    /// What is the potential issue when multiple threads access flag without volatile?
}

public class VisibilityTest {

    @Test
    public void fix_me() throws InterruptedException {
        VisibilityExample example = new VisibilityExample();
        Thread writerThread = new Thread(() -> {
            example.toggleFlag();
        });
        Thread readerThread = new Thread(() -> {
            while (!example.getFlag()) {
                // Spin until what?
            }
            assertTrue(example.getFlag());
        });

        readerThread.start();
        Thread.sleep(100); // Give reader a what?
        writerThread.start();

        writerThread.join();
        readerThread.join(2000); // Wait with what?


        assertFalse(readerThread.isAlive(), "Reader thread is stuck - visibility issue!");
    }
}