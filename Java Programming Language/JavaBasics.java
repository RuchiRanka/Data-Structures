import java.util.*;


public class JavaBasics {

   public static void avg(int n) {
        
        int sum = 0;
        for(int i=1; i<=n; i++){

            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            sum += num;
        }

        int mean = sum / n;
        System.out.println("Mean is - " + mean);
        
}

    public static boolean isEven(int num){
    
        if(num%2==0)
        return true;
        else return false;
    }

    public static void sumOfDigits(int num){
    
        int sum = 0;
        while(num>0){

            int unit = num%10;
            sum += unit;
            num/=10;
        }
        System.out.println(sum);
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        sumOfDigits(num);
    }

}