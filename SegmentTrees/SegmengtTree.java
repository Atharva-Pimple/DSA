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

    public static int getSumUtil(int i,int start,int end,int qi,int qj){
        if(qj <= start || end <= qi){
            return 0;
        }else if(qi <= start && qj >=end){
            return tree[i];
        }else{
            int mid=(start+end)/2;
            int left=getSumUtil(2*i+1,start,mid,qi,qj);
            int right=getSumUtil(2*i+2,mid+1,end,qi,qj);
            return left+right;
        }
    }

    public static int getSum(int arr[],int qi,int qj){
        int n=arr.length;
        return getSumUtil(0,0,n-1,qi,qj);
    }

    public static void updateUtil(int i,int start,int end, int idx, int diff){
        if(start>idx || end<idx){
            return;
        }

        tree[i] +=diff;
        if(start != end){
            int mid=(start+end)/2;
            updateUtil(2*i+1,start,mid,idx,diff);
            updateUtil(2*i+2,mid+1,end,idx,diff);
        }
    }

    public static void update(int arr[],int idx,int val){
        int n=arr.length;
        int diff=val-arr[idx];
        arr[idx]=val;

        // Segment tree updation
        updateUtil(0,0,n-1,idx,diff);

    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);

        buildTree(arr,0,0,n-1);

        // Print Tree

        // for(int i=0;i<tree.length;i++){
        //     System.out.print(tree[i]+" ");
        // }

        System.out.println(getSum(arr,2,5));
        update(arr,2,2);
        System.out.println(getSum(arr,2,5));
        
    }
}