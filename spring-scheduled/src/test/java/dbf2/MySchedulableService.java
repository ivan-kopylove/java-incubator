// com.example.MyTransactionalService.java
package dbf2;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

class MySchedulableService
{
    public static int FIXED_DELAY = 0;
    public static int FIXED_RATE = 0;

    @Scheduled(fixedDelay = 1000)
    public void fixedDelay() throws InterruptedException
    {
        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
        Thread.sleep(5000);
        FIXED_DELAY++;
    }

    @Scheduled(fixedRate = 1000)
    public void fixedRate() throws InterruptedException
    {
        System.out.println("Fixed rate task - " + System.currentTimeMillis() / 1000);
        Thread.sleep(5000);
        FIXED_RATE++;
    }



}


@Async
class MySchedulableService2
{
    public static int FIXED_RATE_ASYNC = 0;

    @Scheduled(fixedRate = 1000)
    public void fixedRateAsync() throws InterruptedException
    {
        System.out.println("Fixed rate task async - " + System.currentTimeMillis() / 1000);
        Thread.sleep(5000);
        FIXED_RATE_ASYNC++;
    }


}


