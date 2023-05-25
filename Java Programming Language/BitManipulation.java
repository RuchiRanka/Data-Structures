import java.util.*;

public class BitManipulation {
    
    public static void oddOrEven(int num){
        int bitMask = 1;

        if((num & bitMask) == 0){
            System.out.println("Even number");
        }
        else{
            System.out.println("Odd number");
        }
    }

    public static void getithBit(int num, int i){
        int bitMask = 1<<i;

        if((num & bitMask) == 0){
            System.out.println("The bit is 0");
        }
        else{
            System.out.println("The bit is 1");
        }
    }

    public static void setIthBit(int num, int i){
        int bitMask = 1<<i;

        System.out.println((num | bitMask));
    }

    public static void clearIthBit(int num, int i){
        int bitMask = 1<<i;
        System.out.println(~((~num) | bitMask));
    }

    public static void updateIthBit(int num, int i, int newBit){

        // if(newBit == 1){
        //     setIthBit(num, i);
        // }
        // else{
        //     clearIthBit(num, i);
        // }

        clearIthBit(num, i);
        int bitMask = newBit << i;
        System.out.println(num | bitMask);
    }

    public static void clearLastIthBits(int num, int i){
        // int sum = 0;
        
        // for(int j=0; j<i; j++){
        //     sum += (1<<j);
        // }
        
        // int bitMask = ~(sum);
        // System.out.println(num & bitMask);

        int bitMask = -1<<i;
        System.out.println(num & bitMask);
    }

    public static void clearRangeBits(int num, int start, int end){
        // int sum = 0;

        // for(int i=start; i<=end; i++){
        //     sum += (1<<i);
        // }

        // int bitMask = ~sum;
        // System.out.println(num & bitMask);

        //-------------------------------------------

        // int bitMask = ((-1<<end+1) | (~(-1<<start)));
        // System.out.println(num & bitMask);

        //-------------------------------------------

        int a = (-1 << (end+1));
        int b = (1<<start) - 1;
        int bitMask = a | b;
        System.out.println(num & bitMask);
    }

    public static void checkPowerOfTwo(int num){
        int bitMask = num - 1;
        
        if((num & bitMask) == 0){
            System.out.println("It is power of 2");
        }
        else{
            System.out.println("It is not a power of 2");
        }
    }

    public static void countSetBits(int num){
        int count = 0;

        while(num > 0){
            if((num & 1) == 1){
                count++;
            }
            num = num>>1;
        }
        System.out.println(count);
    }

    public static void fastExponentiation(int a, int pow){
        int ans = 1;

        while(pow>0){
            if((pow & 1) == 1){
                ans = a * ans;
            }
            a *= a;
            pow = pow>>1;
        }
        System.out.println(ans);
    }

    public static void modularExponentiation(int a, int pow, int x){
        int ans = 1;

        while(pow>0){
            if((pow & 1) == 1){
                ans = a * ans;
            }
            a *= a;
            pow = pow>>1;
        }
        System.out.println(ans%x);
    }

    public static void main(String args[]){

        // //Binary AND 
        // System.out.println(5&6);

        // //Binary OR
        // System.out.println(5|6);

        // //Binary XOR
        // System.out.println(5^6);

        // //Binary 1's Complement
        // System.out.println(~5);
        // System.out.println(~0);

        // //Binary Left Shift
        // System.out.println(5<<2);

        // //Binary Right Shift
        // System.out.println(6>>1);

        // oddOrEven(100);
        // oddOrEven(3);
        // oddOrEven(11);
        // oddOrEven(14);

        // getithBit(15, 2);

        // setIthBit(10,2);

        // clearIthBit(10,1);

        // updateIthBit(10, 2, 1);

        // clearLastIthBits(15, 2);

        // clearRangeBits(2515, 2, 7);
        // clearRangeBits(10, 2, 4);

        // checkPowerOfTwo(6);

        // countSetBits(15);

        // fastExponentiation(3,2);

        modularExponentiation(2, 3, 5);
    }
}
