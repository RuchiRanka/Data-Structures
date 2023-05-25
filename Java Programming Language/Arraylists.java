import java.util.*;

public class Arraylists {

    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
        System.out.println(list);
    }

    public static void containerWater(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++) {
                int height = Math.min(list.get(i),list.get(j));
                int width = j-i;
                int area = height * width;
                max = Math.max(max, area);
            }
        }
        System.out.println("Max water held is - " + max);
    }

    public static void containerWaterOptimized(ArrayList<Integer> list) {
        int lp = 0;
        int rp = list.size()-1;
        int max = 0;
        while(lp<rp) {
            int height = Math.min(list.get(lp),list.get(rp));
            int width = rp-lp;
            int area = height * width;
            max = Math.max(max,area);

            if(list.get(lp)<list.get(rp)) {
                lp++;
            }
            else {
                rp--;
            }
        }
        System.out.println(max);
    }

    public static boolean pairSum1BF(ArrayList<Integer> list, int target) {
        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++) {
                if(list.get(i) + list.get(j) == target) {
                    // System.out.println(list.get(i) + "," + list.get(j));
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairSum1Optimized(ArrayList<Integer> list, int target) {
        int lp = 0;
        int rp = list.size()-1;
        while(lp < rp) {
            if(list.get(lp) + list.get(rp) == target) {
                // System.out.println(list.get(lp) + "," + list.get(rp));
                // lp++;
                return true;
            }
            else if(list.get(lp) + list.get(rp) < target) {
                lp++;
            }
            else {
                rp--;
            }
        }
        return  false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int lp=0,rp=0;
        for(int i=1; i<list.size(); i++) {
            if(list.get(i)<list.get(i-1)) {
                lp = i;
                rp = i-1;
                break;
            }
        }
        int n = list.size();
        while(lp != rp) {
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }
            else if(list.get(lp) + list.get(rp) < target) {
                lp = (lp+1)%n;
            }
            else {
                rp = (n+rp-1)%n;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<String> list2 = new ArrayList<>();
        // ArrayList<Boolean> list3 = new ArrayList<>();

        // //add operation
        // list1.add(1);
        // list1.add(2);
        // list1.add(3);
        // list1.add(4);
        // list1.add(5);
        // System.out.println(list1);

        // //get element
        // System.out.println(list1.get(1));

        // //remove element
        // list1.remove(1);
        // System.out.println(list1);

        // //set element
        // list1.set(2,10);
        // System.out.println(list1);

        // //contains element
        // System.out.println(list1.contains(4));
        // System.out.println(list1.contains(3));

        // //add element (additional property)
        // list1.add(1,9);
        // System.out.println(list1);

        // //size()
        // System.out.println(list1.size());
        // for(int i=0; i<list1.size(); i++) {
        //     System.out.print(list1.get(i) + " ");
        // }
        // System.out.println();

        // //reverse arraylist - O(n)
        // for(int i=list1.size()-1; i>=0; i--) {
        //     System.out.print(list1.get(i) + " ");
        // }
        // System.out.println();

        // // max in arraylist - O(n)
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<list1.size(); i++) {
        //     // if(max<list1.get(i)) {
        //     //     max = list1.get(i);
        //     // }
        //     max = Math.max(max, list1.get(i));
        // }
        // System.out.println(max);

        // //swap 2 numbers
        // int idx1 = 1, idx2 = 3;
        // swap(list1,idx1,idx2);

        // //sorting of AL
        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(2);
        // list1.add(5);
        // list1.add(9);
        // list1.add(6);
        // list1.add(3);
        // System.out.println(list1);

        // //ascending order
        // Collections.sort(list1);
        // System.out.println(list1);

        // //descending order
        // Collections.sort(list1, Collections.reverseOrder());
        // System.out.println(list1);

        // //2D AL 
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(1); list1.add(2); list1.add(3); list1.add(4); list1.add(5);
        // mainList.add(list1);
    
        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(2); list2.add(4); list2.add(6); list2.add(8); list2.add(10);
        // mainList.add(list2);
    
        // ArrayList<Integer> list3 = new ArrayList<>();
        // list3.add(3); list3.add(6); list3.add(9); list3.add(12); list3.add(15);
        // mainList.add(list3);

        // System.out.println(mainList);

        // for(int i=0; i<mainList.size(); i++) {
        //     ArrayList<Integer> currList = mainList.get(i);
        //     for(int j=0; j<currList.size(); j++) {
        //         System.out.print(currList.get(j) + " ");
        //     }
        //     System.out.println();
        // }

        // //Container with most water 
        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1); height.add(8); height.add(6); height.add(2); height.add(5); height.add(4); height.add(8); 
        // height.add(3); height.add(7);
        // //Brute Force - O(n^2)
        // containerWater(height);
        // //Optimized (2 pointer approach) - O(n)
        // containerWaterOptimized(height);
        
        // //Pair Sum-1 
        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(1); list1.add(2); list1.add(3); list1.add(4); list1.add(5);
        // //Brute Force - O(n^2)
        // System.out.println(pairSum1BF(list1, 5));
        // //2 pointer approach - O(n)
        // // pairSum1Optimized(list1, 5);
        // System.out.println(pairSum1Optimized(list1, 5));

        //Pair Sum-2 (Sorted & Rotated ArrayList)
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(11); list1.add(15); list1.add(6); list1.add(8); list1.add(9); list1.add(10); 
        System.out.println(pairSum2(list1, 16));        
    }
}
