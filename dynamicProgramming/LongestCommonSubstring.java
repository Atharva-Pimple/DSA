public class LongestCommonSubstring{
    public static int lcsgTab(String str1,String str2){
        int m=str1.length();
        int n=str2.length();
        int dp[][]=new int[m+1][n+1];
        int ans=0;

        for(int i=0;i<m+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<n+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                    ans=Math.max(ans,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }

        return ans;
    }

    public static void main(String args[]){
        String s1="ABCDGH";
        String s2="ACDGHR";

        System.out.print(lcsgTab(s1,s2));
    }
}