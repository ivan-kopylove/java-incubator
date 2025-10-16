package leetcode.L23.a2;

import java.util.PriorityQueue;

class MySolution70
{
    ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
        {
            return null;
        }

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

        ListNode head = queue.poll();
        ListNode current = head;

        while(!queue.isEmpty())
        {
            current.next = queue.poll();

            current = current.next;   
        }

        // and a tail-based operation - what if I don't implement it, what linked-list specific situation could happen?

        return head;
    }
}