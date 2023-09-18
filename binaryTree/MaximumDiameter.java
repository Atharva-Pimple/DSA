public class MaximumDiameter{
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

    static class Info{
        int ht;
        int diam;

        public Info(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
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

        public static int height(Node root){
            if(root==null){
                return 0;
            }

            int lh=height(root.left);
            int rh=height(root.right);

            return Math.max(lh,rh)+1;
        }

        public static int diameter(Node root){
            if(root==null){
                return 0;
            }

            int ld=diameter(root.left);
            int lh=height(root.left);
            int rd=diameter(root.right);
            int rh=height(root.right);

            int selfd=lh+rh+1;
            return Math.max(selfd,Math.max(ld,rd));
        }

        public static Info diameter2(Node root){
            if(root==null){
                return new Info(0,0);
            }

            Info leftInfo=diameter2(root.left);
            Info rightInfo=diameter2(root.right);

            int diam=Math.max(Math.max(leftInfo.diam,rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
            int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;

            return new Info(ht,diam);
        }
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,6,-1,7,-1,-1,3,-1,-1};
        // int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
         
        // System.out.print(tree.diameter(root));
        System.out.println(tree.diameter2(root).diam);
        System.out.print(tree.diameter2(root).ht);
    }
}


