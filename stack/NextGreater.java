import java.util.*;

public class NextGreater{
    
    public static void main(String args[]){
        Stack<Integer> s=new Stack<>();
        int arr[]={6,8,0,1,3};
        int nxtGrt[]=new int[arr.length];

        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[i]>=arr[s.peek()]){
                s.pop();
            }

            if(s.isEmpty()){
                nxtGrt[i]=-1;
            }else{
                int prevGrt=s.peek();
                nxtGrt[i]=arr[prevGrt];
            }

            s.push(i);
        }

        for(int i=0;i<nxtGrt.length;i++){
            System.out.print(nxtGrt[i]+" ");
        }
    }
}