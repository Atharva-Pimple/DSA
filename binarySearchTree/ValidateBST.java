import java.util.*;

public class ValidateBST{
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

    public static boolean isValid(Node root,Node min,Node max){
        if(root==null){
            return true;
        }

        if(min != null && min.data >= root.data){
            return false;
        }

        else if(max != null && max.data <=root.data){
            return false;
        }

        return  isValid(root.left,min,root) && isValid(root.right,root,max);
    }

    public static void main(String args[]){
        int[] nodes={8,5,3,1,4,6,10,11,14};
        // int nodes[]={1,1,1};
        Node root=null; 

        for(int i=0;i<nodes.length;i++){
            root=insert(root,nodes[i]);
        }

        System.out.print(isValid(root,null,null));        

    }
}