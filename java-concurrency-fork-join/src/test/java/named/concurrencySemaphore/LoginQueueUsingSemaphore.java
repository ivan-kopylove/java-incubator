package named.concurrencySemaphore;

import java.util.concurrent.Semaphore;

class LoginQueueUsingSemaphore
{

    private final Semaphore semaphore;

    LoginQueueUsingSemaphore(int slotLimit)
    {
        semaphore = new Semaphore(slotLimit);
    }

    boolean tryLogin()
    {
        boolean result = semaphore.tryAcquire();
        if (result)
        {
            System.out.println("a");
        }
        else
        {
            System.out.println("b");
        }
        return result;
    }

    void logout()
    {
        semaphore.release();
    }

    int availableSlots()
    {
        return semaphore.availablePermits();
    }
}
