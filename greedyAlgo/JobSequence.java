import java.util.*;

public class JobSequence{
    static class Job{
        int id;
        int  profit;
        int deadLine;

        public Job(int i,int p,int d){
            id=i;
            profit=p;
            deadLine=d;
        }
    }

    public static void main(String args[]){
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs=new ArrayList<>();

        for(int i=0;i<jobInfo.length;i++){
            jobs.add(new Job(i, jobInfo[i][1], jobInfo[i][0]));
        }

        Collections.sort(jobs, (obj1, obj2)-> obj2.profit-obj1.profit);// decending order on profit basis
        // for ascending obj1.profit-obj2.profit

        ArrayList<Integer> seq=new ArrayList<>();
        int time=0;

        for(int i=0;i<jobs.size();i++){
            Job curr=jobs.get(i);
            if(curr.deadLine > time){
                time++;
                seq.add(curr.id);
            }
        }

        System.out.println("Maximum Jobs="+seq.size());

        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
    }
}