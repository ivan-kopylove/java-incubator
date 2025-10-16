package heap.a31d;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

class References
{
    private static final ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();

    static ReferenceQueue<VeryBig> getRq()
    {
        return rq;
    }

    static void checkQueue()
    {
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null)
        {
            System.out.println("In que: " + inq.get());
        }
    }
}
