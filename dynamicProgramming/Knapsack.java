// 0 1 knapsack

public class Knapsack{
    // recursion
    public static int knapsack(int val[],int wt[], int W,int n){
        if(n==0 || W==0){
            return 0;
        }
        
        if(wt[n-1]<= W){//valid
            int ans1=val[n-1]+knapsack(val,wt,W-wt[n-1],n-1);//include
            int ans2=knapsack(val,wt,W,n-1);//exclude

            return Math.max(ans1,ans2);
        }else{// not valid
            return knapsack(val,wt,W,n-1);//exclude
        }
    }

    //DP memoization
    public static int knapsackMemo(int val[],int wt[], int W,int n, int dp[][]){
        if(n==0 || W==0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n-1]<= W){//valid
            int ans1=val[n-1]+knapsackMemo(val,wt,W-wt[n-1],n-1,dp);//include
            int ans2=knapsackMemo(val,wt,W,n-1,dp);//exclude

            dp[n][W]=Math.max(ans1,ans2);
            return dp[n][W];
        }else{// not valid
            dp[n][W]= knapsackMemo(val,wt,W,n-1,dp);//exclude
            return dp[n][W];
        }
    }

    //by tabulation
    public static int knapsackTab(int val[],int wt[],int W){
        int n=val.length;
        int dp[][]=new int[n+1][W+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }

        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }


        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int v=val[i-1];
                int w=wt[i-1];
                if(w<= j){
                    int inc=v+dp[i-1][j-w];
                    int exc=dp[i-1][j];
                    dp[i][j]=Math.max(inc,exc);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        return dp[n][W];
    }

    public static void main(String args[]){
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        int dp[][]=new int[val.length+1][W+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }

        // System.out.print(knapsack(val,wt,W,val.length));
        // System.out.print(knapsackMemo(val,wt,W,val.length,dp));
        System.out.print(knapsackTab(val,wt,W));
    }
}