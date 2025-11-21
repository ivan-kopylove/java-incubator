package named.concurrencyWaitNotify01;

class Waiter implements Runnable
{
    private final Message msg;

    Waiter(Message m)
    {
        this.msg = m;
    }

    @Override
    public void run()
    {
        synchronized (msg)
        {
            String name = Thread.currentThread()
                                .getName();

            try
            {
                System.out.println(name + " waiting");
                msg.wait();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(name + " thread got notified");

            System.out.println(name + " processed: " + msg.getMsg());
        }
    }
}