
public class SortedArrToBST{ 
    static class Node{
        int data;
        Node right,left;

        public Node(int data){
            this.data=data;
            this.left = this.right =null;
        }
    }

    public static Node createBST(int arr[],int st,int ed){
        if(st>ed){
            return null;
        }
        int mid=(st+ed)/2;

        Node newNode=new Node(arr[mid]);
        newNode.left=createBST(arr,st,mid-1);
        newNode.right=createBST(arr,mid+1,ed);

        return newNode;
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
        int arr[]={3,5,6,8,10,11,12};

        Node root=createBST(arr,0,arr.length-1);
        preorder(root);
        
    }
}