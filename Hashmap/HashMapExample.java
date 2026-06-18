
import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("china", 80);
        hm.put("US", 50);
        hm.put("Nepal", 6);
        hm.put("Indonesia", 5);
        // System.out.println(hm);

        // //Get
        // int population = hm.get("India");
        // System.out.println(population);

        // hm.remove("India"); 
        // System.out.println(hm);
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            int maxVal = Integer.MIN_VALUE;
            int currVal = hm.get(k);
            if(maxVal < currVal){
                maxVal = currVal;
            }
            System.out.println(maxVal);
            // System.out.println("Key="+ k +"," + "Value="+ hm.get(k));
        }
    }
}
