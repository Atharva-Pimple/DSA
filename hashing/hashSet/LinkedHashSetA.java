import java.util.*;

public class LinkedHashSetA{
    public static void main(String args[]){
        HashSet<String> cities=new HashSet<>();

        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Bengaluru");
        cities.add("Chennai");
        cities.add("Kolkata");
        // UnOrder
        System.out.println(cities);

        LinkedHashSet<String> citiesL=new LinkedHashSet<>();
        citiesL.add("Mumbai");
        citiesL.add("Delhi");
        citiesL.add("Bengaluru");
        citiesL.add("Chennai");
        citiesL.add("Kolkata");
        // Oreder of insertion
        System.out.println(citiesL);
    }
}