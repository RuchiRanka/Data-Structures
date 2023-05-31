import java.util.*;

public class HashMapB {
    public static void main(String[] args) {
        // //Create
        // HashMap<String, Integer> hm = new HashMap<>();

        // //Insert Key-Value Pair
        // hm.put("India", 150);
        // hm.put("China", 100);
        // hm.put("USA", 50);

        // //Contains Key
        // System.out.println(hm.containsKey("India"));
        // System.out.println(hm.containsKey("Indonesia"));

        // //Get Value from the Key
        // System.out.println(hm.get("India"));
        // System.out.println(hm.get("Indonesia"));

        // //Remove Key-Value Pair
        // System.out.println(hm.remove("China"));

        // //Size of the HashMap
        // System.out.println(hm.size());

        // //Checks if HashMap is Empty or not
        // System.out.println(hm.isEmpty());

        // //Clears out all Key-Value Pairs of HashMap
        // hm.clear();
        // System.out.println(hm.isEmpty());


        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India",100);
        hm.put("Indonesia",10);
        hm.put("China",150);
        hm.put("USA",50);
        hm.put("Nepal",5);

        //Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for(String k : keys) { //forEach Loop
            System.out.println("key = " + k + ", value = " + hm.get(k));
        }
    }
}
