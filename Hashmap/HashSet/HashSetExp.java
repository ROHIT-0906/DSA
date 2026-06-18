

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExp {
   public static void main(String[] args) {
       HashSet<String> cities = new HashSet<>();

       cities.add("Mumbai");
       cities.add("Chennai");
       cities.add("Benguluru");
       cities.add("Pune");

       Iterator it = cities.iterator();

       while(it.hasNext()){
        System.out.println(it.next());
       }

       for(String city: cities){
        System.out.println(city);
       }
   } 
}
