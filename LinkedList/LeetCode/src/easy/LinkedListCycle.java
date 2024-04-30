package easy;

import hard.ReverseNodesinkGroup;

public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val)
        { this.val = val;
            this.next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
            ListNode fast=head;
            ListNode slow=head;

            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(slow==fast)
                    return true;

            }
            return false;
    }
}
