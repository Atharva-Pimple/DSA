public class LinearSearch {
    public static int linearSearch(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    public  static void main(String args[]){
        int arr[]={2,4,6,3,8,1,14,37,10};
        int key =1;

        System.out.print(linearSearch(arr, key));
    }
}
