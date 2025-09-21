package named.concurrencyBasic01;

import org.junit.jupiter.api.Test;

import static heap.cb2d.EducationalStrengthness.EDUCATION_MODE;
import static heap.cb2d.EducationalStrengthness.KOAN;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class VisibilityExample
{
    private boolean flag = false;

    public void toggleFlag()
    {
        flag = true;
    }

    public boolean getFlag()
    {
        return flag;
    }
}

public class VisibilityTest
{

    @Test
    void fix_me() throws InterruptedException
    {
        if (EDUCATION_MODE == KOAN)
        {
            fail("try to fix me");
        }
        else
        {
            return;
        }

        VisibilityExample example = new VisibilityExample();

        Thread writerThread = new Thread(() -> {
            example.toggleFlag();
        });

        Thread readerThread = new Thread(() -> {
            while (!example.getFlag())
            {
                // Spin until what?
            }
            assertTrue(example.getFlag());
        });

        readerThread.start();
        Thread.sleep(100); // Give reader a what?
        writerThread.start();

        writerThread.join();
        readerThread.join(2000); // why should I provide 2000?


        assertFalse(readerThread.isAlive(), "Reader thread is stuck - visibility issue!");
    }
}