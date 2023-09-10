import java.util.*;

public class IndianCurrency{
    public static void main(String args[]){
        Integer coins[]={1,2,5,10,20,50,100,500,2000};
        int amount=590;

        Arrays.sort(coins, Comparator.reverseOrder());

        ArrayList<Integer> ans=new ArrayList<>();

        int tCoins=0;
        int i=0;
        while(i<coins.length && amount>=0){
            if(coins[i]<= amount){
                amount -= coins[i];
                tCoins++;
                ans.add(coins[i]);
                continue;
            }

            i++;
        }

        System.out.println("Coins used(min):"+tCoins);
        for(int k=0;k<ans.size();k++){
            System.out.print(ans.get(k)+" ");
        }
    }
}