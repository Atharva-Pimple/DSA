public class LinkedList{
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
    public static int size;

    public void addFirst(int data){// O(1)
        // Step1-create new node
        Node newNode= new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        // Step2-assign head as next
        newNode.next= head;

        // Step3- newnode as head
        head=newNode;
    }

    public void addLast(int data){//O(1)
        // Step1-create new node
        Node newNode= new Node(data);
        size++;

        if(head==null){
            head=tail=newNode;
            return;
        }

        tail.next= newNode;

        tail=newNode;

    }

    public void add(int idx, int data){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        Node temp=head;
        int i=0;
        size++;

        while(i< idx-1){
            temp=temp.next;
            i++;
        }

        newNode.next=temp.next;
        temp.next=newNode;
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
        
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }

        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
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

    public int itrSearch(int key){
        Node temp=head;
        int i=0;

        while(temp != null){
            if(temp.data==key){
                return i;
            }

            temp=temp.next;
            i++;
        }

        return -1;
    }

    public int helper(Node head,int key){
        if(head == null){
            return -1;
        }

        if(head.data==key){
            return 0;
        }

        int idx=helper(head.next,key);
        if(idx == -1){
            return -1;
        }

        return idx+1;
    }

    public int recSearch(int key){
        return helper(head,key);
    }

    public void reverse(){
        Node next;
        Node prev=null;
        Node curr = tail= head;

        while(curr != null){
            next= curr.next;
            curr.next=prev;
            prev=curr;
            curr= next;
        }
        head=prev;
    }

    public void removeNthFromLast(int n){
        int sz=0;
        Node temp=head;

        while(temp != null){
            temp=temp.next;
            sz++;
        }

        if(n==size){
            head=head.next;
            return;
        }

        Node prev=head;
        int iToFind=sz-n;
        int i=1;
        while(i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    public static void main(String args[]){
        LinkedList ll=new LinkedList();

        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.add(3,9);
        ll.print();
        // System.out.println(ll.size);
        // ll.removeFirst();
        // ll.print();
        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.size);
        // System.out.println(ll.recSearch(2));
        // ll.reverse();
        ll.removeNthFromLast(2);
        ll.print();
        
        
    }
}