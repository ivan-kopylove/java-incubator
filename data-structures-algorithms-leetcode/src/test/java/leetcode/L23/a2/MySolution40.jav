package leetcode.L23.a2;

import java.util.PriorityQueue;

class MySolution40
{
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for(int i = 0; i < lists.length; i++)
        {
            ListNode current = lists[i];

            while(current != null)
            {
                queue.offer(current);

                current = current.next;
            }
        }

        return X // provided I have to return X, what should I do?
    }
}