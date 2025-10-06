package leetcode.L23.a2;

import java.util.PriorityQueue;


class MySolutionFinal
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

        ListNode head = queue.poll();
        ListNode current = head;

        while(!queue.isEmpty())
        {
            current.next = queue.poll();

            current = current.next;   
        }

        if(current != null) // what situation this can be null?
        {
            current.next = null;
        }

        return head;
    }
}