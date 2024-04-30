package easy;

//https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
public class ReverseALinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    static class ModifyList{

        public Node addAtEnd(int data,Node head){
            Node newNode=new Node(data);
            if(head==null){
                head=newNode;
                return head;
            }
                Node curr=head;
                while(curr.next!=null) {
                    curr = curr.next;
                }
                curr.next=newNode;
                return head;
            }

        public static void print(Node temp){
            Node curr=temp;

            while(curr!=null){
                System.out.print(curr.data + " ->");
                curr=curr.next;
            }
        }
    }

    public static void main(String args[]){
        Node head=null;

        ModifyList modifyList=new ModifyList();
        head=modifyList.addAtEnd(1,head);
        head=modifyList.addAtEnd(2,head);
        head=modifyList.addAtEnd(3,head);
        head=modifyList.addAtEnd(4,head);
        head=modifyList.addAtEnd(5,head);

        head=reverseList(head);
        modifyList.print(head);

    }

   static  Node reverseList(Node head)
    {
        if(head==null)
            return null;

        Node curr=head;
        Node prev=null;
        Node front=null;

        while(curr!=null){
            front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }
        return prev;
    }
}
