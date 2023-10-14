import java.util.*;

public class LinkedHashMapA{
    public static void main(String args[]){
        HashMap<String,Integer> hm=new HashMap<>();

        hm.put("India",240);
        hm.put("Australia",112);
        hm.put("NewZealand",97);
        hm.put("Nepal",68);
        hm.put("Bhutan",43);

        LinkedHashMap<String,Integer> lhm=new LinkedHashMap<>();

        lhm.put("India",240);
        lhm.put("Australia",112);
        lhm.put("NewZealand",97);
        lhm.put("Nepal",68);
        lhm.put("Bhutan",43);

        // Not ordered
        System.out.println(hm);
        // Oreder in entries
        System.out.println(lhm);
        
    }
}