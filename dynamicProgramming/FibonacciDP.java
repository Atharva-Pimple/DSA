public class FibonacciDP{
        // by recursion O(2^n)
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }

        return fibonacci(n-1)+fibonacci(n-2);
    }

    // by DP memoization O(n)
    public static int fibonacciMemo(int n ,int f[]){
        if(n==0 || n==1){
            return n;
        }

        if(f[n] != 0){
            return f[n];
        }

        f[n]=fibonacci(n-1)+fibonacci(n-2);
        return f[n];
    }

    // by tabulation
    public static int fibonacciTabulation(int n ){
        int f[]=new int[n+1];
        f[0]=0;
        f[1]=1;

        for(int i=2;i<=n;i++){
            f[i]=f[i-1]+f[i-2];
        }

        return f[n];
    }

    public static void main(String args[]){
        int n=5;
        int f[]=new int[n+1];

        // System.out.print(fibonacci(n));
        // System.out.print(fibonacciMemo(n,f));
        System.out.print(fibonacciTabulation(n));
    }
}