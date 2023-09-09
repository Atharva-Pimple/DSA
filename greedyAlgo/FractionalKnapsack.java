import java.util.*;

public class FractionalKnapsack{
    public static void main(String args[]){
        int weight[]={10,20,30};
        int val[]={60,100,120};
        int capacity=50;

        double ratio[][]=new double[weight.length][2];

        for(int i=0;i<weight.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1]));

        int ans=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>=weight[idx]){
                ans += val[idx];
                capacity -=weight[idx];
            }else{
                ans +=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }

        System.out.print("Final value ="+ans);
    }
}