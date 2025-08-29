package heap.a3f0;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Facets:
 * - concurrency
 */
class SynchronizedExampleTest
{
    @Test
    void threadDangerousRun() throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CounterThreadDangerous summation = new CounterThreadDangerous();

        IntStream.range(0, 1000)
                 .forEach(count -> executorService.submit(summation::calculate));
        executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);

        assertTrue(summation.getSum() < 1000);
    }

    @Test
    void threadSafeRun() throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadSafeCounter summation = new ThreadSafeCounter();

        IntStream.range(0, 1000)
                 .forEach(count -> executorService.submit(summation::calculate));
        executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getSum());
    }

    @Test
    void threadSafeRun2() throws InterruptedException
    {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CounterThreadSafeBlock summation = new CounterThreadSafeBlock();

        IntStream.range(0, 1000)
                 .forEach(count -> executorService.submit(summation::calculate));
        executorService.awaitTermination(2000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getSum());
    }

    class ThreadSafeCounter
    {
        private int sum = 0;

        public synchronized void calculate()
        {
            setSum(getSum() + 1);
        }

        public int getSum()
        {
            return sum;
        }

        public void setSum(int sum)
        {
            this.sum = sum;
        }
    }

    class CounterThreadSafeBlock
    {
        private int sum = 0;

        public void calculate()
        {
            synchronized (this)
            {
                setSum(getSum() + 1);
            }
        }

        public int getSum()
        {
            return sum;
        }

        public void setSum(int sum)
        {
            this.sum = sum;
        }
    }


    class CounterThreadDangerous
    {
        private int sum = 0;

        public void calculate()
        {
            setSum(getSum() + 1);
        }

        public int getSum()
        {
            return sum;
        }

        public void setSum(int sum)
        {
            this.sum = sum;
        }
    }
}