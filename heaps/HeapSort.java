public class HeapSort{
    public static void heapify(int arr[],int i,int size){
        int left=2*i+1;
        int right=2*i+2;
        int maxIDX=i;

        if(left < size && arr[left] > arr[maxIDX] ){
            maxIDX=left;
        }

        if(right < size && arr[right] > arr[maxIDX] ){
            maxIDX=right;
        }

        if(maxIDX != i){
            int temp=arr[i];
            arr[i]=arr[maxIDX];
            arr[maxIDX]=temp;

            heapify(arr,maxIDX,size);
        }
    }
    public static void hSort(int arr[]){
        int n=arr.length;
        // build max heap
        for(int i=n/2;i>=0;i--){//for the ancestors | non root nodes
            heapify(arr,i,n);
        }

        //Push Largest at End
        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,0,i);
        }
    }
    public static void main(String args[]){
        int arr[]={1,2,4,5,3};
        hSort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}