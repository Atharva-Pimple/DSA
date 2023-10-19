import java.util.*;

public class Heaps{

    static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();

        public void add(int data){
            arr.add(data);

            int x=arr.size()-1;//child index
            int par=(x-1)/2; // Parent index

            while(arr.get(x) < arr.get(par)){
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

                x=par;
                par=(x-1)/2;
            }
        }

        private void heapify(int i){
            int left=2*i+1;//left child
            int right=2*i+2;//right child
            int minIDX=i;

            if(left <arr.size() && arr.get(left)<arr.get(i)){
                minIDX=left;
            }

            if(right <arr.size() && arr.get(right)<arr.get(i)){
                minIDX=right;
            }

            if(minIDX != i){
                // swap
                int temp=arr.get(i);
                arr.set(i,arr.get(minIDX));
                arr.set(minIDX,temp);

                heapify(minIDX);
            }
        }

        public int remove(){
            int data=arr.get(0);

            // Swap first and last
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,data);

            // Delete last
            arr.remove(arr.size()-1);

            // Heapify (fixing heap)
            heapify(0);
            return data;
        }

        public int peek(){
            return arr.get(0);
        }

        public boolean isEmpty(){
            return arr.size()==0;
        }

    }
    public static void main(String args[]){
        Heap h=new Heap();
        h.add(3);
        h.add(4);
        h.add(1);  
        h.add(5);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}