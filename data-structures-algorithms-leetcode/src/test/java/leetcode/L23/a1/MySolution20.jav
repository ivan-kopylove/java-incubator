package leetcode.L23.a1;


class MySolution20
{
    public ListNode mergeKLists(ListNode[] lists) {

        while(true) // what if there is no this external loop?
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
        }
    }
}