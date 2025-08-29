package heap.aa9b.one;

class MyLongRunningTask implements Runnable
{
    private final OnCompleteListener onCompleteListener;

    public MyLongRunningTask(OnCompleteListener onCompleteListener)
    {
        this.onCompleteListener = onCompleteListener;
    }

    @Override
    public void foo()
    {
        try
        {
            Thread.sleep(5 * 1000); // sleep for 5 seconds and pretend to be working
            onCompleteListener.onComplete();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
