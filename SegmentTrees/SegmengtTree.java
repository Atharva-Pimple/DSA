// tree contain 2n-1 nodes
public class SegmengtTree{
    static int tree[];
    public static void init(int n){
        tree=new int[4*n];
    }

    public static void buildTree(int arr[],int i,int start,int end){
        if(start == end){
            tree[i]=arr[start];
            return;
        }

        int mid=(start+end)/2;
        buildTree(arr,2*i+1,start,mid);
        buildTree(arr,2*i+2,mid+1,end);

        tree[i]=tree[2*i+1]+tree[2*i+2];
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);

        buildTree(arr,0,0,n-1);

        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }
    }
}