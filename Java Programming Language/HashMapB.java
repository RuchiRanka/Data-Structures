import java.util.*;

public class HashMapB {
    public static void majorityElem(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            // if(hm.containsKey(arr[i])) {
            //     hm.put(arr[i], hm.get(arr[i])+1);
            // }
            // else {
            //     hm.put(arr[i],1);
            // }

            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }

        // Set<Integer> keySet = hm.keySet();
        for(Integer key : hm.keySet()) {
            if(hm.get(key)>arr.length/3) {
                System.out.println(key);
            }
        }
    }

    public static boolean validAnagrams(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s1.length(); i++) {
            char ch = s1.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<s2.length(); i++) {
            char ch = s2.charAt(i);
            if(hm.get(ch) != null) {
                if(hm.get(ch) == 1) {
                    hm.remove(ch);
                }
                else {
                    hm.put(ch, hm.get(ch)-1);
                }
            }
            else {
                return false;
            }
        }

        return hm.isEmpty();
    }

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

        // HashMap<String, Integer> hm = new HashMap<>();
        // hm.put("India",100);
        // hm.put("Indonesia",10);
        // hm.put("China",150);
        // hm.put("USA",50);
        // hm.put("Nepal",5);
        // System.out.println(hm);
        
        // //Iterate
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);
        
        // for(String k : keys) { //forEach Loop
        //     System.out.println("key = " + k + ", value = " + hm.get(k));
        // }
            
        // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        // lhm.put("India",100);
        // lhm.put("Indonesia",10);
        // lhm.put("China",150);
        // lhm.put("USA",50);
        // lhm.put("Nepal",5);
        // System.out.println(lhm);
        
        // TreeMap<String, Integer> tm = new TreeMap<>();
        // tm.put("India",100);
        // tm.put("Indonesia",10);
        // tm.put("China",150);
        // tm.put("USA",50);
        // tm.put("Nepal",5);
        // System.out.println(tm);

        // int arr[] = {1,3,2,5,1,3,1,5,1};
        // majorityElem(arr);

        String s1 = "race";
        String s2 = "care";
        System.out.println(validAnagrams(s1, s2));
    }
}
