import java.util.*;

public class IterartingHashSet{
    public static void main(String args[]){
        HashSet<String> cities=new HashSet<>();

        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Bengaluru");
        cities.add("Chennai");
        cities.add("Kolkata");

        // for(String city : cities){
        //     System.out.println(city);
        // }

        Iterator it=cities.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}