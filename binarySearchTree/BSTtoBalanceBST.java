import java.util.*;

public class BSTtoBalanceBST{ 
    static class Node{
        int data;
        Node right,left;

        public Node(int data){
            this.data=data;
            this.left = this.right =null;
        }
    }

    public static Node createBST(ArrayList<Integer> inorder,int st,int ed){
        if(st>ed){
            return null;
        }
        int mid=(st+ed)/2;

        Node newNode=new Node(inorder.get(mid));
        newNode.left=createBST(inorder,st,mid-1);
        newNode.right=createBST(inorder,mid+1,ed);

        return newNode;
    }  

    public static void getInorder(Node root,ArrayList<Integer> inorder){
        if(root==null){
            return;
        }

        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);
    }

    public static Node balanceBST(Node root){
        ArrayList<Integer> inorder=new ArrayList<>();
        getInorder(root,inorder);

        root=createBST(inorder,0,inorder.size()-1);

        return root;
    }

    
    public static void preorder(Node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]){
        Node root=new Node(8);
        root.left=new Node(6);
        root.left.left=new Node(5);
        root.left.left.left=new Node(3);

        root.right=new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);

        root=balanceBST(root);
        preorder(root);
        
    }
}