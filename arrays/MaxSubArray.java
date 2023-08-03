public class MaxSubArray{
    public static void bruteForce(int arr[]){
        int maxsum= Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int curSum=0;
                for(int k=i;k<=j;k++){
                    curSum +=arr[k];
                }
                if(curSum> maxsum){
                    maxsum=curSum;
                }
            }
        }

        System.out.print(maxsum);
    }

    public static void prefixMTD(int arr[]){
        int maxsum= Integer.MIN_VALUE;
        int prefix[]=new int [arr.length];

        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int curSum= i==0? prefix[j] : prefix[j]-prefix[i-1];

                if(curSum> maxsum){
                    maxsum=curSum;
                }
            }
        }

        System.out.print(maxsum);
    }

    public static void kadanes_algo(int arr[]){
        int cs=0;
        int ms=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            cs=cs+arr[i];
            if(cs<0){
                cs=0;
            }

            ms=Math.max(ms,cs);
            System.out.println(ms);
        }                
        System.out.print("Maxsum= "+ms);


    }
    public static void main(String args[]){
        int arr[]={2,4,-6,8,10};
        // bruteForce(arr);
        // prefixMTD(arr);
        kadanes_algo(arr);
    }
}