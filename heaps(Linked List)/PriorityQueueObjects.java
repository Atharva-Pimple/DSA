import java.util.*;

public class PriorityQueueObjects{
    static class Student implements Comparable<Student>{
        int rank;
        String name;

        public Student(String name,int rank){
            this.name=name;
            this.rank=rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }
    public static void main(String args[]){
        PriorityQueue<Student> pq=new PriorityQueue<>();

        pq.add(new Student("A",534));
        pq.add(new Student("A",15));
        pq.add(new Student("A",6));
        pq.add(new Student("A",678));
        pq.add(new Student("A",597));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+"->"+pq.peek().rank);
            pq.remove();
        }
    }
}