public class CheckPalindrome{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }

    }

    public static Node head;
    public static Node tail;

    public void addLast(int data){
        Node newNode=new Node(data);

        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
        
    }

    public void print(){//O(n)
        if(head==null){
            System.out.println("Linked List is Empty!!!");
            return;
        }

        Node temp=head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }

        System.out.println("null");
    }

    private Node findMid(Node head){
        Node fast=head;
        Node slow=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public boolean CheckPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        // 1:find mid
        Node mid =findMid(head);

        // 2:reverse 2nd half
        Node curr=mid;
        Node prev=null;
        Node next;

        while(curr != null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node left=head;
        Node right=prev;
        // 3:check if equal
        while(right != null){
            if(right.data != left.data){
                return false;
            }
            right=right.next;
            left=left.next;
        }

        return true;
    }
    public static void main(String args[]){
        CheckPalindrome ll=new CheckPalindrome();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);

        ll.print();
        System.out.print(ll.CheckPalindrome());

    }
}