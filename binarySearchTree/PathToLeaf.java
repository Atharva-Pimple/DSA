import java.util.*;

public class PathToLeaf{
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

    public static void printArr(ArrayList<Integer> arr){
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+"->");
        }
        System.out.print("null");
    }

    public static void root2Leaf(Node root, ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        
        arr.add(root.data);
        if(root.left==null && root.right==null){
            printArr(arr);
            System.out.println();
        }
        root2Leaf(root.left,arr);
        root2Leaf(root.right,arr);
        arr.remove(arr.size()-1);
    }

    public static void main(String args[]){
        // int[] nodes={5,1,3,4,2,7};
        int[] nodes={8,5,3,1,4,6,10,11,14};
        Node root=null;

        for(int i=0;i<nodes.length;i++){
            root=insert(root,nodes[i]);
        }

        ArrayList<Integer> arr=new ArrayList<>();
        root2Leaf(root,arr);

    }
}