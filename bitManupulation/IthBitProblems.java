public class IthBitProblems{
    public static int getIthBit(int i,int n){
        int bitmask=1<<i;
        if((n & bitmask)==0){
            return 0;
        }else{
            return 1;
        }
    }
    public static int setIthBit(int i,int n){
        int bitmask=1<<i;
        return (n | bitmask);
    }

    public static int clearIthBit(int i,int n){
        int bitmask= ~(1<<i);
        return (n & bitmask);
    }

    public static int updateIthBit(int n,int i, int newbit){
        // if(newbit==0){
        //     return clearIthBit(i,n);
        // }else{
        //     return updateIthBit(i,n);
        // }

        n=clearIthBit(i,n);
        int bitmask=1<<i;
        return (n | bitmask);
    }

    public static int clearIBits(int n,int i){
        int bitmask=(~0)<<i;
        return n & bitmask;
    }

    public static int clearIBitsInRange(int n,int i,int j){
        int a=(~0)<<(j+1);
        int b=(1<<i)-1;
        int bitmask=(a | b);
        return n & bitmask;
    }
    public static void main(String args[]){
        // System.out.print(getIthBit(3,10));
        // System.out.print(setIthBit(2,10));
        // System.out.print(clearIthBit(1,10));
        // System.out.print(updateIthBit(10,2,1));
        // System.out.print(clearIBits(15,2));
        System.out.print(clearIBitsInRange(10,2,4));


    }
}