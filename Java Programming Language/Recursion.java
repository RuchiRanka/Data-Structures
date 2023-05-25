public class Recursion {
    
    public static void decreasingOrder(int n) {

        if(n==1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        decreasingOrder(n-1);
    }

    public static void increasingOrder(int n) {
        
        if(n==1) {
            System.out.println(n);
            return;
        }
        increasingOrder(n-1);
        System.out.println(n);
    }

    public static int fact(int n) {
        
        if(n==0) {
            return 1;
        }
        int fn1 = fact(n-1);
        int fn = n * fn1;
        return fn;
        
    } 

    public static int printSumOfNat(int n) {

        if(n == 1){
            return 1;
        }
        int fn = printSumOfNat(n-1);
        int sum = n + fn;
        return sum;
    }

    public static int nthFibonacci(int n) {

        if(n==0) {
            return 0;
        }

        if(n==1) {
            return 1;
        }

        int fn = nthFibonacci(n-1) + nthFibonacci(n-2);
        return fn;
    }

    public static boolean isSort(int arr[], int i) {

        if(i == arr.length-1) {
            return true;
        }

        if(arr[i] > arr[i+1]) {
            return false;
        }

        return isSort(arr,i+1);
    }

    public static String firstOccur(int arr[], int num, int i) {

        if(arr[i] == num) {
            return "First occurence of the element in the array is at index " + i;
        }

        if(i == arr.length-1) {
            return "Element does not exist in the array."; 
        }

        return firstOccur(arr,num,i+1);
    }

    public static String lastOccur(int arr[], int num, int i) {

        if(arr[i] == num) {
            return "Last occurence of the element in the array is " + i;
        }

        if(i == 0) {
            return "Element does not exist in the array."; 
        }

        return lastOccur(arr,num,i-1);
    }

    public static int lastOccurence(int arr[], int key, int i) {

        if(i == arr.length) {
            return -1;
        }

        int isFound = lastOccurence(arr,key,i+1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }

        return isFound;
    }

    public static int printPower(int x, int n) {

        if(n == 1) {
            return x;
        }
        int pow = x * printPower(x,n-1);

        return pow;
    }

    public static int powerOptimized(int x, int n) {

        if(n == 1) {
            return x;
        }
        if(n % 2 == 0) {
            return powerOptimized(x,n/2) * powerOptimized(x,n/2);
        }
        else{
            return x * powerOptimized(x,(n-1)/2) * powerOptimized(x,(n-1)/2); 
        }
    }

    public static int tilingProblem(int n) {

        if(n == 0 || n == 1) {
            return 1;
        }

        //vertical choice
        int fnm1 = tilingProblem(n-1);

        //horizontal choice
        int fnm2 = tilingProblem(n-2);

        return fnm1 + fnm2;
    }

    public static void duplicates(String str, int idx, StringBuilder newStr, boolean map[]) {

        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar - 'a'] == true ) {
            duplicates(str, idx+1, newStr, map);
        }
        else {
            map[currChar - 'a'] = true;
            duplicates(str, idx+1, newStr.append(currChar), map);
        }
    }

    public static int friendsPairing(int n) {

        if(n == 1 || n == 2) {
            return n;
        }

        //single
        int fnm1 = friendsPairing(n-1);

        //pairing
        int fnm2 = friendsPairing(n-2) * (n-1);

        return fnm1 + fnm2;
    }

    public static void binaryStr(int n, int lastPlace, String str) {

        if(n == 0) {
            System.out.println(str);
            return;
        }

        binaryStr(n-1,0,str+"0");
        if(lastPlace == 0) {
            binaryStr(n-1,1,str+"1");
        }
    }

    public static void main(String args[]) {
        
        // decreasingOrder(10);

        // increasingOrder(10);

        // System.out.println(fact(5));

        // System.out.println(printSumOfNat(10));

        // System.out.println(nthFibonacci(5));
        
        // int arr[] = {1,2,3,6,5};
        // System.out.println(isSort(arr,0));

        // int arr[] = {1,2,3,5,4,5,6,3,7};
        // System.out.println(firstOccur(arr,7,0));
        // System.out.println(lastOccur(arr,10,arr.length-1));
        // int arr[] = {5,5,5,5};
        // System.out.println(lastOccurence(arr,5,0));

        // System.out.println(printPower(2,10));

        // System.out.println(powerOptimized(2,10));

        // System.out.println(tilingProblem(4));

        // String str = "appnnacollege";
        // duplicates(str, 0, new StringBuilder(""), new boolean[26]);

        // System.out.println(friendsPairing(4));

        // binaryStr(3,0,"");

    }
}
