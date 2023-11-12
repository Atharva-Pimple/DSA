public class LongestCommonSubsequence{
    // recursion
    public static int lcs(String s1,String s2, int m,int n){
        if(m==0 || n==0){
            return 0;
        }

        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return 1+lcs(s1,s2,m-1,n-1);
        }

        int ans1=lcs(s1,s2,m,n-1);
        int ans2=lcs(s1,s2,m-1,n);

        return Math.max(ans1,ans2);
    } 

    // memoization
    public static int lcsMemo(String s1,String s2, int m,int n, int dp[][]){
        if(m==0 || n==0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }        

        if(s1.charAt(m-1)==s2.charAt(n-1)){
            dp[m][n]= 1+lcs(s1,s2,m-1,n-1);
            return dp[m][n];
        }

        int ans1=lcs(s1,s2,m,n-1);
        int ans2=lcs(s1,s2,m-1,n);

        dp[m][n]= Math.max(ans1,ans2);
        return dp[m][n];
    } 

    // tabulation
    public static int lcsTab(String s1,String s2, int m,int n){
        int dp[][]=new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
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

        return dp[m][n];
    }


    public static void main(String args[]){
        String str1="abcdge";
        String str2="abedg";

        int dp[][]=new int[str1.length()+1][str1.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }

        // System.out.print(lcs(str1,str2,str1.length(),str2.length()));
        // System.out.print(lcsMemo(str1,str2,str1.length(),str2.length(),dp));
        System.out.print(lcsTab(str1,str2,str1.length(),str2.length()));

    }
}