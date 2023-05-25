import java.util.*;
public class Leetcode {

    // public static void plusOne(String s) {
        
    //     StringBuilder str = new StringBuilder(s);
    //     int index[] = new int[s.length()];
    //     char arr[] = new char[s.length()];
    //     int k=0;
    //     for(int i=0; i<s.length(); i++) {
    //     if(s.charAt(i)== 'a' ||s.charAt(i)== 'e' ||s.charAt(i)== 'o' ||s.charAt(i)== 'i' ||s.charAt(i)== 'u'){
    //             arr[k] = s.charAt(i);
    //             index[k] = i;
    //             k++;
    //         }

    //     }
    //     int i = 0;
    //     while(k>=0) {
    //         str.setCharAt(index[i],arr[k]);
    //         i++;
    //         k--;
    //     }
    //     String str1 = str.toString();
    //     System.out.println(str1);
    // }

    public static void bruteForceNextGreaterElem(int arr[], int nextGreater[]) {
        for(int i=0; i<arr.length; i++) {
            nextGreater[i] = -1;
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i]<arr[j]) {
                    nextGreater[i] = arr[j];
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        // String s = "hello";
        // plusOne(s);

        int arr[] = {6,8,0,1,3};
        int nextGreater[] = new int[arr.length];
        bruteForceNextGreaterElem(arr, nextGreater);

        for(int i=0; i<nextGreater.length; i++) {
            System.out.println(nextGreater[i]);
        }
    }
}


