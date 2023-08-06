import java.util.ArrayList;

public class PairSumRotated{
    public static boolean bruteForce(ArrayList<Integer> arr,int target){
        for(int i=0;i<arr.size();i++){
            for(int j=i+1;j<arr.size();j++){
                if(arr.get(i)+arr.get(j)==target){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean pairSum(ArrayList<Integer> arr,int target){
        int pivot=-1;
        int n=arr.size();

        for(int i=0;i<arr.size();i++){
            // rotation point
            if(arr.get(i)>arr.get(i+1)){
                pivot=i;
                break;
            }
        }

        int rp=pivot+1;
        int lp=pivot;

        while(lp != rp){
            if(arr.get(lp)+arr.get(rp)==target){
                return true;
            }

            if(arr.get(lp)+arr.get(rp) < target){
                rp=(rp+1)%n;
            }else{
                lp=(n+lp-1)%n;
            }
        }

        return false;
    }
    
    public static void main(String args[]){
        ArrayList<Integer> arr=new ArrayList<>();

        arr.add(11);
        arr.add(15);
        arr.add(6);
        arr.add(8);
        arr.add(9);
        arr.add(10);

        int target=25;
        // System.out.print(bruteForce(arr,target));
        System.out.print(pairSum(arr,target));

    }
}