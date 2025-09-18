package heap.f50e;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

import static org.hamcrest.MatcherAssert.assertThat;

class LockKoanTest
{
    @Test
    void what_is_the_purpose_of_this_example()
    {
        // given
        ReentrantLock lock1 = new ReentrantLock(true);
        ReentrantLock lock2 = new ReentrantLock(true);

        new Thread(() -> {
            while (true)
            {
                lock1.tryLock();

                sleep(5_000);

                if (lock2.tryLock())
                {
                    System.out.println("thread 1 - lock 2 locked");
                }
                else
                {
                    System.out.println("thread 1 - lock 2 cannot be locked, unlocking lock 1");
                    lock1.unlock();
                    continue;
                }

                System.out.println("thread 1 - reached end");
                break;
            }

            lock1.unlock();
            lock2.unlock();
        }).start();


        new Thread(() -> {
            while (true)
            {
                lock2.tryLock();

                sleep(5_000);

                if (lock1.tryLock())
                {
                    System.out.println("thread 2 - lock 1 locked");
                }
                else
                {
                    System.out.println("thread 2 - lock 1 cannot be locked, unlocking lock 1");
                    lock2.unlock();
                    continue;
                }

                System.out.println("thread 2 - reached end.");
                break;
            }

            lock2.unlock();
            lock1.unlock();
        }).start();

        // when
        sleep(15_000);
    }

    private static void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
