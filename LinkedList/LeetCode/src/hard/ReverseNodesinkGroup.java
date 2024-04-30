package hard;

//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodesinkGroup {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val)
      {
          this.val = val;
      }
      ListNode(int val, ListNode next)
      { this.val = val;
          this.next = next;
      }
 }

 public static ListNode addAtEnd(int val,ListNode head){
        ListNode newNode=new ListNode(val);
        if(head==null){
            head=newNode;
            return head;
        }else{
            ListNode curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=newNode;
            return head;
        }
 }

    private static void print(ListNode head) {

        ListNode curr=head;
        while(curr!=null){
            System.out.print(curr.val+"->");
            curr=curr.next;
        }
    }

 public static void main(String args[]){
     ListNode head=null;
     head=addAtEnd(1,head);
     head=addAtEnd(2,head);
     head=addAtEnd(3,head);
     head=addAtEnd(4,head);
     head=addAtEnd(5,head);

     int k=2;
     head=reverseKGroup(head,k);
     print(head);
 }

    public static ListNode reverseKGroup(ListNode head, int k) {
         ListNode temp=head;
         ListNode prev=null;

         while(temp!=null){
             ListNode kthNode=Klimit(temp,k);
             if(kthNode==null){
                 if(prev!=null){
                     prev.next=temp;
                 }
                 break;
             }
             ListNode newNode=kthNode.next;
             kthNode.next=null;
             reverse(temp);
             if(temp==head){
                 head=kthNode;
             }else{
                 prev.next=kthNode;
             }
             prev=temp;
             temp=newNode;
         }
         return head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        ListNode front=null;

        while(curr!=null){
            front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
    }

    private static ListNode Klimit(ListNode temp, int k) {
        k=k-1;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }

}
