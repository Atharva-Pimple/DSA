public class MirrorBST{ 
    static class Node{
        int data;
        Node right,left;

        public Node(int data){
            this.data=data;
            this.left = this.right =null;
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

    public static Node mirror(Node root){
        if(root==null){
            return root;
        }

        Node left=mirror(root.left);
        Node right=mirror(root.right);

        root.left=right;
        root.right=left;

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
        int nodes[]={8,5,10,6,3,11};
        Node root=null;

        for(int i=0;i<nodes.length;i++){
            root=insert(root,nodes[i]);
        }

        preorder(root);
        root=mirror(root);
        System.out.println();
        preorder(root);
    }
}