package leetcode.L23.a1;


class MySolutionFinal
{
    public ListNode mergeKLists(ListNode[] lists) {

        int minIdx = 0;
        
        ListNode resultFirst = null;
        ListNode resultNext = null;

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

            if(lists[minIdx] != null)
            {
                if(resultFirst == null)
                {
                    resultFirst = lists[minIdx];
                    resultNext = lists[minIdx];
                }
                else
                {
                    resultNext.next = lists[minIdx];
                    resultNext = resultNext.next;
                }

                lists[minIdx] = lists[minIdx].next;
            }
            else
            {
                return resultFirst;
            }
        }
    }
}