public class FriendsPairing{

    public static int pair(int n){
        if(n==1 || n==2){
            return n;
        }

        // Single
        int fnm1=pair(n-1);

        // pair
        int fnm2=pair(n-2);
        int totPair=(n-1) * fnm2;

        return fnm1 + totPair;

    }
    public static void main(String args[]){
        System.out.print(pair(4));
    }
}
