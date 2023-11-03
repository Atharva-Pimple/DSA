import java.util.*;

public class ClimbingStairs{
    // by recursion O(2^n)
    public static int countWays(int n){
        if(n==0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        return countWays(n-1)+countWays(n-2);
    }

    // by DP memoization O(n)
    public static int countMemo(int n ,int ways[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(ways[n] != -1){
            return ways[n];
        }

        ways[n]=countMemo(n-1,ways)+countMemo(n-2,ways);
        return ways[n];
    }

    // by tabulation
    public static int countWaysTab(int n ){
        int ways[]=new int[n+1];
        ways[0]=1;

        for(int i=1;i<=n;i++){
            if(i==1){
                ways[i]=ways[i-1]+0;
            }else{
                ways[i]=ways[i-1]+ways[i-2];
            }
        }

        return ways[n];
    }

    public static void main(String args[]){
        /*
        Q: if person can climb 1 or 2 stairs at time how many ways he can reach stair n
        */
        int n=5;
        int ways[]=new int[n+1];
        Arrays.fill(ways,-1);

        // System.out.print(countWays(n));
        // System.out.print(countMemo(n,ways));
        System.out.print(countWaysTab(n));
    }
}