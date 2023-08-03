public class BinarySearch {
    public static int binarySearch(int arr[],int key){
        int start=0, end=arr.length;

        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==key){
                return mid;
            }

            if(arr[mid]< key){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
    public  static void main(String args[]){
        int arr[]={2,4,6,7,8,10,11,12,23,56};//sorted
        int key =56;

        System.out.print(binarySearch(arr, key));
    }
}
