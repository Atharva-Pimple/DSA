public class TillingProblem{
    public static int tilling(int n){
        if(n==0 || n==1){
            return 1;
        }
        // Vertical
        int fnm1=tilling(n-1);
        // Horizontal
        int fnm2=tilling(n-2);

        return fnm1+fnm2;
    }
    public static void main(String args[]){
        System.out.print(tilling(3));
    }
}