import java.util.*;

public class TreeMapA{
    public static void main(String args[]){
        HashMap<String,Integer> hm=new HashMap<>();

        hm.put("India",240);
        hm.put("Australia",112);
        hm.put("NewZealand",97);
        hm.put("Nepal",68);
        hm.put("Bhutan",43);

        TreeMap<String,Integer> tm=new TreeMap<>();

        tm.put("India",240);
        tm.put("Australia",112);
        tm.put("NewZealand",97);
        tm.put("Nepal",68);
        tm.put("Bhutan",43);

        // Not ordered
        System.out.println(hm);
        // Sorted by keys
        System.out.println(tm);
        
    }
}