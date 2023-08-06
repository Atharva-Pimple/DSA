import java.util.ArrayList;

public class PairSum{
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
        int lp=0,rp=arr.size()-1;

        while(lp<rp){
            if(arr.get(lp)+arr.get(rp)==target){
                return true;
            }

            if(arr.get(lp)+arr.get(rp)>target){
                rp--;
            }else{
                lp++;
            }
        }

        return false;

    }
    public static void main(String args[]){
        ArrayList<Integer> arr=new ArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        int target=9;
        // System.out.print(bruteForce(arr,target));
        System.out.print(pairSum(arr,target));

    }
}