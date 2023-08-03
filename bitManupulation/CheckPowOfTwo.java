public class CheckPowOfTwo{
    public static boolean check(int n){
        return (n & (n-1))==0;
    }
    public static void main(String args[]){
        System.out.println(check(8));
        System.out.println(check(3));
        System.out.println(check(16));
    }
}