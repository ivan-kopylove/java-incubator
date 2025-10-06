package leetcode.L23;


class MySolution30
{
    public ListNode mergeKLists(ListNode[] lists) {
        int minIdx = 0;

        while(true)
        {
            for(int i = 0; i < lists.length; i++)
            {
                if(lists[i] != null)
                {
                    if(lists[minIdx] == null)
                    {
                        minIdx = i;
                    }
                    else if(lists[i].val < lists[minIdx].val)
                    {
                        minIdx = i;
                    }
                }
            }

            // what happens here, after the inner loop above?
            if(lists[minIdx] != null)
            {

            }
            else
            {
                // what does this mean?
            }
        }
    }
}