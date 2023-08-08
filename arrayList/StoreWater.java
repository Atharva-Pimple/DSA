import java.util.ArrayList;

public class StoreWater{

    public static int bruteForce(ArrayList<Integer> height){
        int maxWater=Integer.MIN_VALUE;

        for(int i=0;i<height.size();i++){
            for(int j=i+1;j<height.size();j++){
                int ht=Math.min(height.get(i),height.get(j));
                int width=j-i;
                int cs=ht*width;
                maxWater=Math.max(maxWater,cs);
            }
        }

        return maxWater;
    }
    // Two pointer approach
    public static int storeWater(ArrayList<Integer> height){
        int maxWater=Integer.MIN_VALUE;
        int lp=0, rp=height.size()-1;

        while(lp<rp){
            int ht=Math.min(height.get(lp),height.get(rp));
            int width=rp-lp;
            int cs=ht*width;
            maxWater=Math.max(cs,maxWater);

            if(lp>rp){
                rp--;
            }else{
                lp++;
            }
        }

        return maxWater;
    }
    public static void main(String args[]){
        ArrayList<Integer> height=new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        // System.out.print(bruteForce(height));
        System.out.print(storeWater(height));
    }
}