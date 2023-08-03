public class TrappingRainwater {
    public static int trapRainwater(int arr[]){
        if(arr.length==1 || arr.length==2){
            return 0;
        }

        int leftmax[]=new int[arr.length];
        int rightmax[]=new int[arr.length];

        leftmax[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            leftmax[i]=Math.max(leftmax[i-1],arr[i]);
        }

        rightmax[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],arr[i]);
        }

        int trappedWater=0;
        for(int i=0;i<arr.length;i++){
            int waterLevel=Math.min(leftmax[i],rightmax[i]);

            trappedWater +=waterLevel - arr[i];
        }

        return trappedWater;
    }
    public static void main(String args[]){
        int arr[]={4,2,0,6,3,2,5};
        System.out.print(trapRainwater(arr));
    }
}
