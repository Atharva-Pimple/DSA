public class BinaryToDecimal{
    public static int binaryToDecimal(int n){
        int poww=0;
        int dec=0;

        while(n>0){
            int ld=n%10;
            dec=dec+ (ld*(int)Math.pow(2,poww));

            n=n/10;
            poww++;
        }

        return dec;
    }

    public static int decimalToBinary(int n){
        int poww=0;
        int bin=0;

        while(n>0){
            int rem=n%2;
            bin=bin+ (rem*(int)Math.pow(10,poww));

            n=n/2;
            poww++;
        }

        return bin;
    }

    public static void main(String args[]){
        // System.out.print(binaryToDecimal(101));
        System.out.print(decimalToBinary(5));

    }
}