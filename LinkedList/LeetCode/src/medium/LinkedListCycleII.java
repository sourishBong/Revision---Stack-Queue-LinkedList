package medium;

public class LinkedListCycleII {

    class ListNode {
      int val;
     ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode detectCycle(ListNode head) {

        if(head==null || head.next==null)
            return null;

        ListNode fast=head;
        ListNode slow=head;
        ListNode entry=head;

        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                while(slow!=entry){
                    slow=slow.next;
                    entry=entry.next;
                }
                return entry;
            }
        }
            return null;
    }
}
