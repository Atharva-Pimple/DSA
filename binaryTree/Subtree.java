public class Subtree{
    static class Node{
        int data;
        Node right;
        Node left;

        public Node(int data){
            this.data=data;
            right=null;
            left=null;
        }
    }

    public static boolean isIdentical(Node root,Node subRoot){
        if(root==null && subRoot==null){
            return true;
        }else if(root==null || subRoot==null || root.data!= subRoot.data){
            return false;
        }

        if(!isIdentical(root.right,subRoot.right)){
            return false;
        }

        if(!isIdentical(root.left,subRoot.left)){
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root,Node subRoot){
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }

        return isSubtree(root.right,subRoot) || isSubtree(root.left,subRoot);
    }
    public static void main(String args[]){
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
         */
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        /*      2
               / \
              4   5
        */
       Node subRoot=new Node(2);
       subRoot.left=new Node(4);
       subRoot.right=new Node(5);
    //    subRoot.left.left=new Node(6);

       System.out.print(isSubtree(root,subRoot));

    }
}