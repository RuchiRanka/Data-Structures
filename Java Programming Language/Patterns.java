import java.util.*;

public class Patterns {

    public static void numberPalindrome(int n){
        
        for(int i=1; i<=n; i++){

            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            while(i>=1){
                System.out.print(i);
                i--;
            }

            // for(int j=i; j>=1; j--){
            //     System.out.print(j);
            // }
            
            for(int j=2; j<=i; j++){
                System.out.print(j);
            }

            System.out.println();
            
        }
        
}
    public static void main( String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        numberPalindrome(num);



    }
}
