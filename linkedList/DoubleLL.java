public class DoubleLL{
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;

        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    public  void addLast(int data){
        Node newNode=new Node(data);
        size++;

        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }

    public int removeFirst(){
        if(size==0){
            System.out.print("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;

    }

    public int removeLast(){
        if(size==0){
            System.out.print("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        int val=tail.data;
        tail=tail.prev;
        tail.next=null;
        size--;
        return val;

    }

    public void print(){
        Node temp=head;
        if(head==null){
            System.out.print("Linked List is empty");
        }

        while(temp!=null){
            System.out.print(temp.data +"<->");
            temp=temp.next;
        }

        System.out.println("null");
    }

    public void reverse(){
        Node prev=null;
        Node curr=head;
        Node next;

        while(curr != null){
            next=curr.next;
            curr.prev=next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public static void main(String args[]){
        DoubleLL dll= new DoubleLL();

        dll.addFirst(3); 
        dll.addFirst(2); 
        dll.addFirst(1);
        dll.addLast(4);
        dll.addLast(5);

        dll.print();
        // System.out.println(dll.size);

        // System.out.println(dll.removeFirst());
        // dll.print();
        // System.out.println(dll.size);

        // System.out.println(dll.removeLast());
        // System.out.println(dll.removeLast());
        // dll.print();
        // System.out.println(dll.size);

        dll.reverse();
        dll.print();

    }
}