import java.util.*;

public class TransformSumTree{
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    static int idx=-1;
    public static Node buildTree(int nodes[]){
        idx++;
        if(nodes[idx]==-1){
            return null;
        }
        Node newNode=new Node(nodes[idx]);
        newNode.left=buildTree(nodes);
        newNode.right=buildTree(nodes);
        

        return newNode;
    }

    public static int transform(Node root){
        if(root==null){
            return 0;
        }

        int lv=transform(root.left);
        int rv=transform(root.right);

        int self=root.data;
        root.data=lv+rv;

        return self+root.data;
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        Node root=buildTree(nodes);
        transform(root);

        preOrder(root);
    }
}