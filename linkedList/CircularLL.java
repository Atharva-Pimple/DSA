public class CircularLL{
    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data=data;
        }
    }

    static Node  addToEmpty(Node last,int data){
        if(last != null){
            return last;
        }
        Node newNode=new Node(data);
        last=newNode;
        newNode.next=last;
        return last;
    }
    static Node addFront(Node last,int data){
        if(last==null){
            return addToEmpty(last,data);
        }
        Node newNode=new Node(data);
        newNode.next=last.next;
        last.next=newNode;
        return last;
    }

    static Node addEnd(Node last,int data){
        if(last==null){
            return addToEmpty(last,data);
        }
        Node newNode=new Node(data);
        newNode.next=last.next;
        last.next=newNode;
        last=newNode;
        return last;
    }

    static Node addAfter(Node last,int data,int item){
        if(last==null){
            return null;
        }

        Node newNode,temp;
        temp=last.next;
        do{
            if(temp.data==item){
                newNode=new Node(data);
                newNode.next=temp.next;
                temp.next=newNode;
                if(temp==last){
                    last=newNode;
                }
                return last;
            }
            temp=temp.next;
        }while(temp!=last.next);

        System.out.println(item+"The given node is not present");
        return last;
    }

    static Node deleteNode(Node last, int key) {
        if (last == null){
            return null;
        }

        if (last.data == key && last.next == last) {
            last = null;
            return last;
        }
        Node temp = last;
        Node d = new Node(-1);
        if (last.data == key) {
            while (temp.next != last) {
            temp = temp.next;
            }
            temp.next = last.next;
            last = temp.next;
        }
        while (temp.next != last && temp.next.data != key) {
            temp = temp.next;
        }
        if (temp.next.data == key) {
            d = temp.next;
            temp.next = d.next;
        }
        return last;
    }

    static void traverse(Node last){
        if(last==null){
            System.out.print("LL is Empty");
        }

        Node temp=last.next;
        do{
            System.out.print(temp.data+" ");
            temp=temp.next;
        }while(temp!=last.next);
    }

    public static void main(String args[]){
        Node last=null;
        last=addToEmpty(last,6);
        last=addEnd(last,8);
        last=addFront(last,2);
        last=addAfter(last,10,2);
        traverse(last);
        last=deleteNode(last,10);
        System.out.println();
        traverse(last);
    }
}