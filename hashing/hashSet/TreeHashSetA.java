import java.util.*;

public class TreeHashSetA{
    public static void main(String args[]){
        HashSet<String> cities=new HashSet<>();

        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Bengaluru");
        cities.add("Chennai");
        cities.add("Kolkata");
        // UnOrder
        System.out.println(cities);

        TreeSet<String> citiesT=new TreeSet<>();
        citiesT.add("Mumbai");
        citiesT.add("Delhi");
        citiesT.add("Bengaluru");
        citiesT.add("Chennai");
        citiesT.add("Kolkata");
        // Sorted  
        System.out.println(citiesT);
    }
}