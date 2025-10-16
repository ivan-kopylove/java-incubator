package named.concurrencyWaitNotify02;

class MyHouse
{

    public void eatPizza()
    {
        synchronized (this)
        {
                try
                {
                    System.out.println("Waiting for pizza...");
                    wait();
                    System.out.println("Got a notification from another thread");
                }
                catch (InterruptedException e)
                {
                    throw new RuntimeException(e);
                }
        }

        System.out.println("Yumyum..");
    }

    public void pizzaGuy()
    {
        synchronized (this)
        {
            System.out.println("Notifying...");
            notifyAll();
        }
    }
}
