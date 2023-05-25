import java.util.*;

public class Strings {
   
    public static void printLetters(String str){

        for(int i=0; i<str.length(); i++){

            System.out.print(str.charAt(i) + " ");
        }
    }

    public static boolean checkPalindrome(String str){

        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                System.out.println("String is not palindrome.");
                return false;
            }
        }
        System.out.println("String is palindrome.");
        return true;
    }

    public static void shortestPath(String str){
        int x = 0, y = 0;
        for(int i=0; i<str.length(); i++){

            if(str.charAt(i) == 'W'){
                x--;
            }

            else if(str.charAt(i) == 'E'){
                x++;
            }

            else if(str.charAt(i) == 'N'){
                y++;
            }

            else if(str.charAt(i) == 'S'){
                y--;
            }
        }
        System.out.println(Math.sqrt((x*x)+(y*y)));
    }
    
    public static void substr(String str, int si, int ei){
        String substr = "";

        for(int i=si; i<ei; i++){
            substr += str.charAt(i);
        }

        System.out.println(substr);
    }

    public static void upperCase(String str){
        StringBuilder sb = new StringBuilder("");
        
        sb.append(Character.toUpperCase(str.charAt(0)));

        for(int i=1; i<str.length(); i++){
            
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static void strCompress(String str){
        
        String newStr = "";

        for(int i=0; i<str.length(); i++){
            Integer count = 1;

            while( i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count > 1){
                newStr += count.toString();
            }
        }
        System.out.println(newStr);
    }

    public static void compressOptimize(String str){

        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<str.length(); i++){
            Integer count = 1;

            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }

            sb.append(str.charAt(i));
            if(count > 1){
                sb.append(count.toString());
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String args[]){

        // String firstName = "Ruchi";
        // String lastName = "Ranka";
        // String fullName = firstName + " " + lastName;

        // Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();
        // System.out.println(name);

        // printLetters(fullName);

        // String str = "madam";
        // checkPalindrome(str);

        // String str = "NNEEE";
        // shortestPath(str);

        // String str = "HelloWorld";
        // String str1 = new String("HelloWorld");

        // if(str.equals(str1)){
        //     System.out.println("Strings are equal.");
        // }
        
        // substr(str,3,5);
        // System.out.println(str.substring(3,5));

        // String str[] = {"Ruchi", "Ranka", "YET", "yet"};

        // String largest = str[0];
        // for(int i=1; i<str.length; i++){
        //     if(largest.compareTo(str[i]) < 0){
        //         largest = str[i];
        //     }
        // }
        // System.out.println(largest);

        // StringBuilder sb = new StringBuilder("");
        // for(char ch ='a'; ch<='z'; ch++){
        //     sb.append(ch);
        // }
        // //O(n)
        // System.out.println(sb);
        // System.out.println(sb.length());

        // String str = "hi, i am ruchi.";
        // upperCase(str);

        String str = "aaabbcccdd";
        // strCompress(str);
        compressOptimize(str);
    }
}
