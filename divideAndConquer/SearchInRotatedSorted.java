public class SearchInRotatedSorted{
    public static int search(int arr[],int tar,int si, int ei){
        if(si>ei){
            return -1;
        }

        int mid=(si+ei)/2;

        if(arr[mid]==tar){
            return mid;
        }
        // If mid on L1
        if(arr[mid]>= arr[si]){
            // tar in left side of L1
            if(arr[si]<=tar && tar<=arr[mid]){
                return search(arr,tar,si,mid);
            }else{
                return search(arr,tar,mid+1,ei);
            }
        }
        // if mid on L2
        else{
            if(arr[mid]<=tar && tar<=arr[ei]){
                return search(arr,tar,mid,ei);
            }else{
                return search(arr,tar,si,mid-1);
            }
        }

    }
    public static void main(String args[]){
        int arr[]={4,5,6,7,8,9,0,1,2,3};
        int tar=9;
        System.out.print(search(arr,tar,0,arr.length-1));

    }
}