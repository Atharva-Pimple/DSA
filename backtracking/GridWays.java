public class GridWays{
    public static int countWays(int i,int j,int n,int m){
        if(i==n-1 && j==m-1){
            return 1;
        }else if(i==n || j==m){
            return 0;
        }
        // Down 
        int dn=countWays(i+1,j,n,m);
        // Right
        int rt=countWays(i,j+1,n,m);

        return dn+rt;
    }
    public static void main(String args[]){
        int n=3,m=3;

        System.out.print(countWays(0,0,n,m));
    }
}