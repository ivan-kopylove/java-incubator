package leetcode.L23.a1;


class MySolution10
{
    ListNode mergeKLists(ListNode[] lists) {
        
            for(int i = 0; i < lists.length; i++)
            {
                if (lists[i] != null)
                {
                    if (lists[minIdx] == null)
                    {
                        minIdx = i; // introduced it in a lazy mode - without a variable desclaration first. why?
                    }
                    else if (lists[i].val < lists[minIdx].val)
                    {
                        minIdx = i;
                    }
                }
            }
        }
    }
}