public class PrintInRange{
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }

        if(root.data > data){
            root.left=insert(root.left,data);
        }else{
            root.right=insert(root.right,data);
        }

        return root;
    }

    public static void printInRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }

        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left,k1,k2);
            System.out.print(root.data + " ");
            printInRange(root.right,k1,k2);
        }

    }

    public static void main(String args[]){
        // int[] nodes={5,1,3,4,2,7};
        int[] nodes={8,5,3,1,4,6,10,11,14};
        Node root=null;

        for(int i=0;i<nodes.length;i++){
            root=insert(root,nodes[i]);
        }

        printInRange(root,5,12);
    }
}