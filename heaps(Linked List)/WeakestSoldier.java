import java.util.*;
public class WeakestSoldier{

    static class Row implements Comparable<Row>{
        int idx;
        int soldier;
        public Row(int idx,int soldier){
            this.idx=idx;
            this.soldier=soldier;
        }

        @Override
        public int compareTo(Row r){
            if(this.soldier==r.soldier){
                return this.idx-r.idx;
            }else{
                return this.soldier-r.soldier;
            }
        }
    }
    
    public static void main(String args[]){
        int k=2;
        int army[][]={{1,0,0,0},
                    {1,1,1,1},
                    {1,1,0,0},
                    {1,0,0,0}};

        PriorityQueue<Row> pq=new PriorityQueue<>();

        for(int i=0;i<army.length;i++){
            int count=0;
            for(int j=0;j<army.length;j++){
                count += army[i][j]== 1? 1:0;
            }
            pq.add(new Row(i,count));
        }

        for(int i=0;i<k;i++){
            System.out.println("R"+pq.remove().idx);
        }
    }
}