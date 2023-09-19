import java.util.*;

public class KthLevelNodes{
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

    public static void kthLevel(Node root,int level ,int k){
        if(root==null){//not neccesary
            return;
        }
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }

        kthLevel(root.left,level+1,k);
        kthLevel(root.right,level+1,k);

    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        Node root=buildTree(nodes);

        kthLevel(root,1,3);

    }
}