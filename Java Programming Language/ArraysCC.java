import java.util.*;


public class ArraysCC {

    public static void sumOf(int num){
    
        int even=0;
        int odd=0;
        System.out.println("Enter inputs-");
        for(int i=1; i<=num; i++){

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            if(n%2==0){
                even+=n;
            }
            else
            odd+=n;
            
        }
        System.out.println("Even sum-" + even + "\nOdd sum -" + odd);

    }

    public static void factorial(int n){

        int fact = 1;
        for(int i=1; i<=n; i++){

            fact*=i;
        }
        System.out.println("Factorial is-" + fact);
    }

    public static void mult_table(int n){

        for(int i=1; i<=10; i++){

            System.out.println(n + " x " + i + " = " + n*i);
        }
    }

    public static void reverseArray(int numbers[]){

        int n = numbers.length;
        int revarray[] = new int[n];
        for(int i=0; i<numbers.length; i++){
            
            revarray[i] = numbers[n-1];
            n--;
        }
        for(int i=0; i<numbers.length; i++ ){
            System.out.print(revarray[i] + " ");
        }
    }

    public static void revArray(int numbers[]){

        int first=0, last = numbers.length-1;
        
        //swap
        for(int i=first; i<=last; i++){

            int temp = numbers[first];
            numbers[first] = numbers[last];
            numbers[last] = temp;
            first++;
            last--;
            
        }
        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
    }

    public static void pairsArray(int numbers[]){

        for(int i=0; i<numbers.length; i++){

            for(int j=i+1; j<numbers.length; j++){
                System.out.println("(" + numbers[i] + "," + numbers[j] + ")");
            }
        }
    }

    public static void subarrays_bruteForce(int numbers[]){

        int ts = (numbers.length * (numbers.length + 1)) / 2;
        int sumarray[] = new int[ts];
        int index = 0;

        for(int i=0; i<numbers.length; i++){
            
            for(int j=i; j<numbers.length; j++){ 

                int sum =0;
                for(int k=i; k<=j; k++){ 

                    System.out.print(numbers[k] + " ");
                    sum += numbers[k];

                }
                
                sumarray[index] = sum;
                index++;

                System.out.println( );

                
            }

        }
        for(int i=0;i<ts; i++){
            System.out.println(sumarray[i]);
        }

    }

    public static void prefixSum(int numbers[]){

        int cursum = 0;
        int maxsum = Integer.MIN_VALUE;

        int prefix[] = new int[numbers.length];
        prefix[0] = numbers[0];
        for(int i=1; i<prefix.length; i++){

            prefix[i] = prefix[i-1] + numbers[i];
        }

        for(int i=0; i<prefix.length; i++){

            for(int j=i; j<prefix.length; j++){

                cursum = i==0 ? prefix[j] : prefix[j] - prefix[i-1];

                if(maxsum < cursum){
                    maxsum = cursum;
                }
            }
        }

        System.out.println(maxsum);
    }

    public static void kadanesAlgo(int numbers[]){

        int cs =0;
        int ms = Integer.MIN_VALUE;

        for(int i=0; i<numbers.length; i++){
            cs += numbers[i];

            if(cs<0){
                cs = 0;
            }
    
            ms = Math.max(ms,cs);
        }
        System.out.println(ms);
    }

    public static void neg_array(int numbers[]){

        int ms = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            ms = Math.max(numbers[i],ms);
        }
        System.out.println(ms);
    }

    public static boolean isPos(int numbers[]){
    
        for(int i=0; i<numbers.length; i++){

            if(numbers[i]>0){
                return true;
            }
            
        }    
        return false;
    }
    
    // public static void kadane(int numbers[]){

    //     for(int i=0; i<numbers.length; i++){

    //         int ms = Integer.MIN_VALUE;
    //         int cs = 0;
    //     }
    // }

    public static int bubbleSort(int numbers[]){

        int n = numbers.length;
        int swaps = 0;
        for(int i=0; i<=n-2; i++){

            for(int j=0; j<=n-i-2; j++){

                if(numbers[j]>numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    swaps++;
                }
            }

            if(swaps == 0){
                return printArr(numbers); 
                 
            }

        }
        return printArr(numbers);

    }

    public static int printArr(int numbers[]){

        
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        return 0;
    }

    public static void selectionSort(int numbers[]){

        for(int i=0; i<numbers.length-1; i++){

            int minPos = i;
            for(int j=i+1; j<numbers.length; j++){

                if(numbers[minPos]>numbers[j]){
                    minPos = j;
                }
            }

            //swap
            int temp = numbers[i];
            numbers[i] = numbers[minPos];
            numbers[minPos] = temp;
        }
        printArr(numbers);
    }

    public static void insertionSort1(int numbers[]){

        for(int i=0; i<numbers.length-1; i++){

            int tempMemory = numbers[i+1];
            for(int j=i; j>=0; j--){

                if(tempMemory<numbers[j]){
                    
                    //swap
                    numbers[j+1] = numbers[j];
                    numbers[j] = tempMemory;
                    
                }
            }
        }

        printArr(numbers);
    }

    public static void insertionSort2(int numbers[]){

        for(int i=1; i<numbers.length; i++){

            int curr = numbers[i];
            int prev = i-1;

            while(prev>=0 && numbers[prev]>curr){
                numbers[prev+1] = numbers[prev];
                prev--;
            }

            numbers[prev+1] = curr;
        }
        printArr(numbers);
    }
    
    public static void countingSort(int numbers[]) {

        int largest = Integer.MIN_VALUE;
        for(int i=0; i<numbers.length; i++){

            largest = Math.max(largest, numbers[i]);
        }

        int count[] = new int[largest+1];
        for(int i=0; i<numbers.length; i++){

            count[numbers[i]]++;
        }

        //sorting
        int j = 0;
        for(int i=0; i<count.length; i++){

            while(count[i]>0){
                
                numbers[j] = i;
                count[i]--;
                j++; 
            }
        }

        printArr(numbers);
        
    }

    public static void trapRain(int numbers[]){
        
        int leftMax[] = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){

            for(int j=0; j<=i; j++){

                leftMax[i] = Math.max(leftMax[i],numbers[j]);
            }
        }

        int rightMax[] = new int[numbers.length];
        for(int i=numbers.length-1; i>=0; i--){

            for(int j=i; j<numbers.length; j++){

                rightMax[i] = Math.max(rightMax[i],numbers[j]);
            }
        }

        // int rightMax[] = new int[numbers.length];
        // for(int i=0; i<numbers.length; i++){

        //     for(int j=numbers.length-1; j>=i; j--){

        //         rightMax[i] = Math.max(rightMax[i],numbers[j]); 
        //     }
        // }

        int sum = 0;
        for(int i=0; i<numbers.length; i++){

            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            sum +=(waterLevel - numbers[i]);
        }

        System.out.println(sum);
    }

    // public static void trappedrain(int numbers[]){

    //     int leftmax[] = new int[numbers.length];
    //     for(int i=0; i<numbers.length; i++){
    //         for(int j=0; j<=i; j++){
                
    //             leftmax[i] = Math.max(numbers[j],leftmax[i]);
    //         }
    //     }

    //     int rightmax[] = new int[numbers.length];
    //     for(int i=0; i<numbers.length; i++){
    //         for(int j=i; j<numbers.length; j++){
                
    //             rightmax[i] = Math.max(numbers[j],rightmax[i]);
    //         }
    //     }

    //     int sum = 0;
    //     for(int i=0; i<numbers.length; i++){

    //         int waterlvl = Math.min(leftmax[i], rightmax[i]);
    //         sum += waterlvl - numbers[i];
    //     }

    //     System.out.println(sum);
    // }

    // public static void stocks(int numbers[]){
        
    //     int diff[] = new int[numbers.length];
    //     int max = 0;
    //     for(int i=0; i<numbers.length; i++){
    //         for(int j=i; j<numbers.length; j++){

    //             diff[i] = Math.max(numbers[j]-numbers[i],diff[i]);

    //         }
    //     }
        
    //     for(int i=0; i<numbers.length; i++){
    //        max = Math.max(diff[i],max);
    //     }
    //     System.out.println(max);
    // }

    public static void buyAndSellStocks(int numbers[]){

        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<numbers.length; i++){

            if(buyPrice < numbers[i]){
                int profit = numbers[i] - buyPrice;
                maxProfit = Math.max(profit,maxProfit);
            }
            else{
                buyPrice = numbers[i];
            }
        }

        System.out.println(maxProfit);
    }

    public static void main(String args[]){

        // Scanner sc = new Scanner(System.in);
        //System.out.println("Enter no. of inputs to be taken-");
        // int num = sc.nextInt();
        //sumOf(num);
        //factorial(num);
        // mult_table(num);
        int numbers[] = {7,1,5,3,6,4};

        //pairsArray(numbers);
        //System.out.println(kadaneAlgo(numbers));

        // if(isPos(numbers) == true){
        //     kadanesAlgo(numbers);
        // }
        // else{
        //     neg_array(numbers);
        // }

        // *******************************************************

        //System.out.println(bubbleSort(numbers));
        //insertionSort2(numbers);
        //trapRain(numbers);
        //trappedrain(numbers);
        buyAndSellStocks(numbers);

    }
}

