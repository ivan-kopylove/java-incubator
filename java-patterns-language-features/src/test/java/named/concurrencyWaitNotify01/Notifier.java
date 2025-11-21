package named.concurrencyWaitNotify01;

class Notifier implements Runnable
{

    private final Message msg;

    Notifier(Message msg)
    {
        this.msg = msg;
    }

    @Override
    public void run()
    {
        String name = Thread.currentThread()
                            .getName();
        System.out.println(name + " started");
        try
        {
            Thread.sleep(2_000);
            synchronized (msg)
            {
                msg.setMsg(name + " Notifier work done");

                //                                msg.notify();
                //                                msg.notify();

                msg.notifyAll();
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}