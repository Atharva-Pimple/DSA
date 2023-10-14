import java.util.*;

public class IterateHashmap{
    public static void main(String args[]){
        HashMap<String,Integer> hm=new HashMap<>();

        hm.put("India",240);
        hm.put("Australia",112);
        hm.put("NewZealand",97);
        hm.put("Nepal",68);
        hm.put("Bhutan",43);

        Set<String> keys=hm.keySet();

        for(String k: keys){
            System.out.println(k+" :"+hm.get(k));
        }
    }
}