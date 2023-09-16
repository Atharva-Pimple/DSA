public class SumNodes{
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

    static class BinaryTree{
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

        public static int sum(Node root){
            if(root==null){
                return 0;
            }

            int lSum=sum(root.left);
            int rSum=sum(root.right);

            return lSum+rSum+root.data;
        }
    }
    public static void main(String args[]){
        // int nodes[]={1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        
        System.out.print(tree.sum(root));
    }
}