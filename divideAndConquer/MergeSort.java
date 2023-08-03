public class MergeSort{
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void mergeSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=(si+ei)/2;
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,ei,mid);
    }

    public static void merge(int arr[],int si,int ei,int mid){
        int newarr[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ei){
            if(arr[i] < arr[j]){
                newarr[k]=arr[i];
                i++;
            }else{
                newarr[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid){
            newarr[k++]=arr[i++];
        }
        while(j<=ei){
            newarr[k++]=arr[j++];
        }

        for(k=0, i=si; k<newarr.length;i++,k++){
            arr[i]=newarr[k];
        }
    }
    public static void main(String args[]){
        int arr[]={6,2,8,9,-3,-6,7};
        mergeSort(arr,0,arr.length-1);
        printArr(arr);
    }
}