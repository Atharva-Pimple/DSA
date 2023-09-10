import java.util.*;

public class ActivitySelection{
    public static void main(String args[]){
        int start[]={0,1,3,5,5,8};
        int end[]={6,2,4,7,9,9};

        int activities[][]=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }

        // Sorting acording end time
        Arrays.sort(activities, Comparator.comparingDouble(o ->o[2]));

        // end time basis sort
        int maxAct=0;
        ArrayList<Integer> ans=new ArrayList<>();

        maxAct=1;
        ans.add(activities[0][0]);
        int lastEnd=activities[0][2];

        for(int i=1;i<start.length;i++){
            if(lastEnd<=activities[i][1]){
                maxAct++;
                lastEnd=activities[i][2];
                ans.add(activities[i][0]); 
            }
        }

        System.out.println("Maximum activities:"+maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
    }
}