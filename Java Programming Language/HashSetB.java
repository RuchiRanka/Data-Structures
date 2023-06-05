import java.util.*;

public class HashSetB {
    public static int distinctElems(int nums[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size();
    }

    public static int union(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        for(Integer elem: set) {
            System.out.print(elem + " ");
        }
        System.out.println();

        return set.size();
    }

    public static int intersection(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        int count=0;
        for(int i=0; i<arr2.length; i++) {
            if(set.contains(arr2[i])) {
                System.out.print(arr2[i] + " ");
                set.remove(arr2[i]);
                count++;
            }
        }
        System.out.println();

        return count;
    }

    public static void itineraryFromTickets1(HashMap<String, String> tickets) {
        HashSet<String> revTickets = new HashSet<>();
        for(String key: tickets.keySet()) {
            revTickets.add(tickets.get(key));
        }

        String start = "";
        for(String key: tickets.keySet()) {
            if(!revTickets.contains(key)) {
                start = key;
            }
        }

        System.out.print(start);
        while(tickets.containsKey(start)) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
    }

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for(String key: tickets.keySet()) {
            revMap.put(tickets.get(key),key);
        }

        for(String key: tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void itineraryFromTickets2(HashMap<String, String> tickets) {
        String start = getStart(tickets);
        System.out.print(start);
        for(String key: tickets.keySet()) {
            System.out.print("->" + tickets.get(start));
            start = tickets.get(start);
        }
    }

    public static int zeroSumSubarray(int arr[]) {
        int sum=0, len=0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(hm.containsKey(sum)) {
                int subarray = i-hm.get(sum);
                len = Math.max(len, subarray);
            }
            else {
                hm.put(sum,i);
            }
        }

        return len;
    }

    public static int KSumSubarray(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int ans = 0;
        for(int j=0; j<arr.length; j++) {
            sum += arr[j];
            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        // HashSet<Integer> set = new HashSet<>();
        // set.add(1);
        // set.add(2);
        // set.add(4);
        // set.add(2);
        // set.add(1);

        // System.out.println(set);

        // if(set.contains(2)) {
        //     System.out.println("Set contains 2");
        // }
        // if(!set.contains(3)) {
        //     System.out.println("Set does not contain 3");
        // }

        // set.remove(2);
        // System.out.println(set);
        // System.out.println(set.size());
        // System.out.println(set.isEmpty());
        // set.clear();
        // System.out.println(set.size());
        // System.out.println(set.isEmpty());

        // HashSet<String> cities = new HashSet<>();
        // cities.add("Delhi");
        // cities.add("Noida");
        // cities.add("Pune");
        // cities.add("Mumbai");

        // Iterator it = cities.iterator();
        // while(it.hasNext()) {
        //     System.out.println(it.next());
        // }

        // for(String city: cities) {
        //     System.out.println(city);
        // }

        // LinkedHashSet<String> lhs = new LinkedHashSet<>();
        // lhs.add("Delhi");
        // lhs.add("Noida");
        // lhs.add("Bengaluru");
        // System.out.println(lhs);
        // lhs.remove("Noida");
        // System.out.println(lhs);

        // TreeSet<String> ts = new TreeSet<>();
        // ts.add("Delhi");
        // ts.add("Noida");
        // ts.add("Mumbai");
        // ts.add("Bengaluru");
        // System.out.println(ts);

        // int nums[] = {4,3,2,5,6,7,3,4,2,1};
        // System.out.println(distinctElems(nums));

        // int arr1[] = {7,3,9};
        // int arr2[] = {6,3,9,2,9,4};
        // System.out.println(union(arr1, arr2));
        // System.out.println(intersection(arr1, arr2));

        // HashMap<String, String> tickets = new HashMap<>();
        // tickets.put("Chennai", "Bengaluru");
        // tickets.put("Mumbai", "Delhi");
        // tickets.put("Goa", "Chennai");
        // tickets.put("Delhi", "Goa");

        // // itineraryFromTickets1(tickets);
        // itineraryFromTickets2(tickets);

        // int arr[] = {15,-2,2,-8,1,7,10,23};
        // System.out.println(zeroSumSubarray(arr));

        // int arr[] = {10,2,-2,-20,10};
        // int k = -10;
        int arr[] = {1,2,3};
        int k = 3;
        System.out.println(KSumSubarray(arr, k));
    }
}

