import java.util.*;
public class MajorityElem{
    public static void main(String args[]){
        int arr[]={1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            // if(hm.containsKey(num)){
            //     hm.put(num,hm.get(num)+1);
            // }else{
            //     hm.put(num,1);
            // }

            hm.put(num, hm.getOrDefault(num,0)+1);
        }

        for(Integer k: hm.keySet()){
            if(hm.get(k) > arr.length/3){
                System.out.print(k+" ");
            }
        }
    }
}