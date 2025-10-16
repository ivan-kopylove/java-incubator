package heap.a3f0;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import com.github.ivan.kopylove.commons.testing.TestBase;
class SynchronizedExampleTest extends TestBase
{
    @Test
    void threadDangerousRun() throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CounterThreadDangerous summation = new CounterThreadDangerous();

        IntStream.range(0, 1000).forEach(count -> executorService.submit(summation::calculate));
        executorService.awaitTermination(2000, MILLISECONDS);

        assertTrue(summation.getSum() < 1000);
    }

    @Test
    void threadSafeRun() throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadSafeCounter summation = new ThreadSafeCounter();

        IntStream.range(0, 1000).forEach(count -> executorService.submit(summation::calculate));
        executorService.awaitTermination(2000, MILLISECONDS);

        assertEquals(1000, summation.getSum());
    }

    @Test
    void threadSafeRun2() throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CounterThreadSafeBlock summation = new CounterThreadSafeBlock();

        IntStream.range(0, 1000).forEach(count -> executorService.submit(summation::calculate));
        executorService.awaitTermination(2000, MILLISECONDS);

        assertEquals(1000, summation.getSum());
    }

    class ThreadSafeCounter
    {
        private int sum = 0;

        synchronized void calculate()
        {
            setSum(getSum() + 1);
        }

        int getSum()
        {
            return sum;
        }

        void setSum(int sum)
        {
            this.sum = sum;
        }
    }

    class CounterThreadSafeBlock
    {
        private int sum = 0;

        void calculate()
        {
            synchronized (this)
            {
                setSum(getSum() + 1);
            }
        }

        int getSum()
        {
            return sum;
        }

        void setSum(int sum)
        {
            this.sum = sum;
        }
    }

    class CounterThreadDangerous
    {
        private int sum = 0;

        void calculate()
        {
            setSum(getSum() + 1);
        }

        int getSum()
        {
            return sum;
        }

        void setSum(int sum)
        {
            this.sum = sum;
        }
    }
}