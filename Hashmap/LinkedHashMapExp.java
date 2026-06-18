
import java.util.*;

public class LinkedHashMapExp {
    
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India",100);
        lhm.put("Australia",50);
        lhm.put("Bhiwandi",3);

        HashMap<String,Integer>hm = new HashMap<>();

        hm.put("India",100);
        hm.put("Australia",50);
        hm.put("Bhiwandi",3);

        TreeMap<String, Integer> tm = new TreeMap<>();

        tm.put("India",100);
    tm.put("Australia",50);
        tm.put("Bhiwandi",3);

        System.out.println(hm);
        System.out.println(lhm);
        System.out.println(tm);
        
    }
}
