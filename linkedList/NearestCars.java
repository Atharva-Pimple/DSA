import java.util.*;

public class NearestCars{
    static class Point implements Comparable<Point> {
        int idx;
        int x;
        int y;
        int distSq;

        public Point(int idx,int x,int y,int distSq){
            this.idx=idx;
            this.x=x;
            this.y=y;
            this.distSq=distSq;
        }

        @Override
        public int compareTo(Point p){
            return this.distSq-p.distSq;
        }
    }
    public static void main(String args[]){
        int points[][]={{3,3},{5,-1},{-2,4},{1,2}};
        int k=2;
        PriorityQueue<Point> pq=new PriorityQueue<>();

        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            int distSq=x*x + y*y;
            pq.add(new Point(i,x,y,distSq));
        }

        for(int i=0;i<k;i++){
            System.out.println("C"+pq.remove().idx);
        }
        
    }
}