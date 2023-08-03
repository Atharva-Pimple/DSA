public class BasicRecursion{

    public static int calcSum(int n){
        if(n==1){
            return 1;
        }

        int sum=n+calcSum(n-1);
        return sum;
    }
    public static int fib(int n){
        if(n==0 || n==1){
            return n;
        }
        int fnm1=fib(n-1);
        int fnm2=fib(n-2);
        return fnm1+fnm2;

    }
    public static void fibonacci(int n){
        for(int i=1;i<=n;i++){
            System.out.print(fib(i)+" ");
        }
    }

    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        
        return isSorted(arr,i+1);

    }

    public static int firstOccurance(int arr[],int key,int i){
        if(arr[i]==key){
            return i;
        }

        return firstOccurance(arr,key,i+1);
    }

    public static int lastOccurance(int arr[],int key,int i){
        if(arr.length==i){
            return -1;
        }
        int isFound=lastOccurance(arr,key,i+1);
        
        if(arr[i]==key && isFound==-1){
            return i;
        }

        return isFound;
    }

    public static void main(String args[]){
        // System.out.print(calcSum(7));
        // fibonacci(10);
        int arr1[]={1,2,4,5,6,8,9};
        int arr2[]={2,3,4,1,6,9,8,4,3};
        // System.out.print(isSorted(arr2,0));
        // System.out.print(firstOccurance(arr2,4,0));
        System.out.print(lastOccurance(arr2,4,0));
    }
}