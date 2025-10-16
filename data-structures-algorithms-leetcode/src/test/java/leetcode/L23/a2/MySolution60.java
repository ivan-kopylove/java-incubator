package leetcode.L23.a2;

import java.util.PriorityQueue;

class MySolution60
{
    ListNode mergeKLists(ListNode[] lists) {
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
            // now I have the full queue, but I need to return the head
        }

        return head;
    }
}