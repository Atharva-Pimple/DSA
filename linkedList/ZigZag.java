public class ZigZag{
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

    public void addFirst(int data){
        Node newNode=new Node(data);

        if(head == null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
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

    public void zigzag(){
        // mid
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;

        // reverse second half
        Node curr=mid.next;
        mid.next=null;
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
        Node nextL, nextR;
        // Merge zigzag
        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            right=nextR;
            left=nextL;
        }
        
    }
    public static void main(String args[]){
        ZigZag ll=new ZigZag();
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        ll.print();
        ll.zigzag();
        ll.print();
    }
}