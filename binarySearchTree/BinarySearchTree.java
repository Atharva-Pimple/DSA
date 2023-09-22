public class BinarySearchTree{
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

    public static void inorder(Node root){
        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }

    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }

        if(root.data==key){
            return true;
        }

        if(root.data > key){
            return search(root.left,key);
        }else{
            return search(root.right,key);
        }
    }

    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left=delete(root.left,val);
        }else if(root.data < val){
            root.right=delete(root.right,val);
        }else{
            //case 1: no child
            if(root.left==null && root.right==null){
                return null;
            }

            // case 2: only one child
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            } 

            // case3: two child
            Node IS=findInorderSuccesor(root.right);
            root.data=IS.data;
            root.right=delete(root.right,IS.data);
        }

        return root;
    }

    public static Node findInorderSuccesor(Node root){
        while(root.left != null){
            root=root.left;
        }

        return root;
    }

    public static void main(String args[]){
        // int[] nodes={5,1,3,4,2,7};
        int[] nodes={8,5,3,1,4,6,10,11,14};
        Node root=null;

        for(int i=0;i<nodes.length;i++){
            root=insert(root,nodes[i]);
        }

        inorder(root);
        System.out.println();

        // if(search(root,7)){
        //     System.out.print("Found");
        // }else{
        //     System.out.print("Not Found");
        // }

        root=delete(root,8);
        inorder(root);

    }
}