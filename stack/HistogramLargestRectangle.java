import java.util.Stack;

public class HistogramLargestRectangle{
    public static void maxArea(int arr[]){
        int n=arr.length;
        int maxArea=0;
        int nsl[]=new int[n];
        int nsr[]=new int[n];

        // smallest next left
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }

            s.push(i);

        }

        // smallest next right
        s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=n;
            }else{
                nsr[i]=s.peek();
            }

            s.push(i);

        }
        
        // maxArea rectangle
        for(int i=0;i<n;i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int curArea=height*width;
            maxArea=Math.max(curArea,maxArea);
        }

        System.out.print("Max Area rectangle= "+maxArea);
    }
    public static void main(String args[]){
        int arr[]={2,1,5,6,2,3};
        maxArea(arr);
    }
}