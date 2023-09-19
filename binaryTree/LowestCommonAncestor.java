import java.util.*;

public class LowestCommonAncestor{
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

    public static boolean getPath(Node root,int k,ArrayList<Node> path){
        if(root==null){
            return false;
        }

        path.add(root);

        if(root.data==k){
            return true;
        }

        boolean findLeft=getPath(root.left,k,path);
        boolean findRight=getPath(root.right,k,path);

        if(findLeft || findRight){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root,int n,int m){
        ArrayList<Node> path1=new ArrayList<>();  
        ArrayList<Node> path2=new ArrayList<>();  

        getPath(root,n,path1);
        getPath(root,m,path2);

        int i=0;
        while(i<path1.size() && i<path2.size()){
            if(path1.get(i) != path2.get(i) ){
                break;
            }

            i++;
        }

        return path1.get(i-1);
    }

    // Approach 2 for better space complexity
    public static Node lca2(Node root,int n,int m){
        if( root==null || root.data==n || root.data==m ){
            return root;
        }

        Node leftLca=lca2(root.left,n,m);
        Node rightLca=lca2(root.right,n,m);

        if(leftLca==null){
            return rightLca;
        }

        if(rightLca==null){
            return leftLca;
        }

        return root;
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        Node root=buildTree(nodes);
        int n=6,m=7;
        // System.out.print(lca(root,n,m).data);
        System.out.print(lca2(root,n,m).data);
    }
}