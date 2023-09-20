import java.util.*;

public class KthAncestor{
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

    public static int kthAncestor(Node root,int n,int k){
        if(root==null){
            return -1;
        }

        if(root.data==n){
            return 0;
        }

        int left=kthAncestor(root.left,n,k);
        int right=kthAncestor(root.right,n,k);

        if(left==-1 && right==-1){
            return -1;
        }

        int m=Math.max(left,right);
        if(m+1==k){
            System.out.print(root.data);
        }

        return m+1;
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        Node root=buildTree(nodes);

        // kthAncestor(root,5,2);
        // kthAncestor(root,5,1);
        kthAncestor(root,7,1);
    }
}