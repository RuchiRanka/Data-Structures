import java.util.*;

import javax.swing.plaf.basic.BasicDesktopIconUI.MouseInputHandler;

public class DP {
    public static int fib(int n, int dp[]) { //Fibonacci - Memoization
        if(n==0 || n==1) {
            return n;
        }
        if(dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fib(n-1, dp) + fib(n-2, dp);
        return dp[n];
    }

    public static int fibTabulation(int n) { //Fibonacci - Tabulation
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static int climbingStairs(int n, int[] dp) { //Climbing Stairs - Memoization
        if(n==0 || n==1) {
            return 1;
        }
        if(dp[n-1] != 0) {
            return dp[n-1];
        }

        dp[n-1] = climbingStairs(n-1, dp)+climbingStairs(n-2, dp);
        return dp[n-1];
    }

    public static int climbingStairs1(int n, int ways[]) { //Climbing Stairs 1 - Memoization  
        if(n==0) {
            return 1;
        }
        if(n<0) {
            return 0;
        }

        if(ways[n] != -1) {
            return ways[n];
        }

        ways[n] = climbingStairs1(n-1, ways) + climbingStairs1(n-2, ways);
        return ways[n];
    }

    public static int climbingStairsTab(int n) { //Climbing Stairs - Tabulation
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++) {
            if(i==1) {
                dp[i] = dp[i-1];
            }
            else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }

    // public static int knapsack1(int val[], int wt[], int W, int curr, int profit, int maxProfit) {
    //     if(curr>=val.length || W-wt[curr]<0) {
    //         if(maxProfit < profit) {
    //             maxProfit = profit;
    //         }
    //         return maxProfit;
    //     }

    //     maxProfit = Math.max(knapsack1(val, wt, W-wt[curr], curr+1, profit+val[curr], maxProfit), knapsack1(val, wt, W, curr+1, profit, maxProfit));
    //     return maxProfit;
    // }

    public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) {
        if(W==0 || n==0) {
            return 0;
        }

        if(dp[n][W] != -1) {
            return dp[n][W];
        }

        if(wt[n-1] <= W) {
            //include
            int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapsack(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }
        else {
            //exclude
            dp[n][W] = knapsack(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static int knapsackTab(int val[], int wt[], int W) {
        int dp[][] = new int[val.length+1][W+1];

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                int value = val[i-1];
                int weight = wt[i-1];
                if(weight<=j) {
                    int ans1 = value + dp[i-1][j-weight];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[val.length][W];
    }

    public static boolean subsetSum(int nums[], int target) {
        boolean dp[][] = new boolean[nums.length+1][target+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = true;
        }
        // // This is already done by default
        // for(int i=1; i<dp[0].length; i++) {
        //     dp[0][i] = false;
        // }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                int w = nums[i-1];
                if(w <= j) {
                    dp[i][j] = dp[i-1][j-w] || dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[nums.length][target];
    }

    public static int unboundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(wt[i-1]<=j) {
                    // int ans1 = val[i-1] + dp[i-1][j-wt[i-1]];
                    int ans2 = dp[i-1][j];
                    int ans3 = val[i-1] + dp[i][j-wt[i-1]];
                    dp[i][j] = Math.max(ans3, ans2);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][W];
    }

    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[n][sum];
    }

    public static int rodCutting(int length[], int price[], int rodLength) {
        int dp[][] = new int[price.length+1][rodLength+1];
        
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(length[i-1]<=j) {
                    dp[i][j] = Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[price.length][rodLength];
    }


    public static int longestCommSubseq(String str1, String str2, StringBuilder subseq, int curr1, int curr2, int maxLength) {  
        for(int i=curr1; i<str1.length(); i++) {
            char ch = str1.charAt(i);
            for(int j=curr2; j<str2.length(); j++) {
                if(ch==str2.charAt(j)) {
                    subseq.append(ch);
                    maxLength = Math.max(maxLength, longestCommSubseq(str1, str2, subseq, i+1, j+1, maxLength));
                    subseq.delete(subseq.length()-1, subseq.length());
                }
            }
        }
        System.out.println(subseq);
        return Math.max(maxLength, subseq.length());
    }

    public static int lcs(String str1, String str2, int n, int m) {
        if(n==0 || m==0) {
            return 0;
        }

        if(str1.charAt(n-1)==str2.charAt(m-1)) {
            return lcs(str1, str2, n-1, m-1) + 1;
        }
        else {
            int ans1 = lcs(str1, str2, n-1, m);
            int ans2 = lcs(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    // LCS - Memoization
    public static int lcsMemo(String str1, String str2, int n, int m, int dp[][]) {
        if(n==0 || m==0) {
            return 0;
        }

        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            dp[n][m] = lcsMemo(str1, str2, n-1, m-1, dp) + 1;
        }
        else {
            int ans1 = lcsMemo(str1, str2, n-1, m, dp);
            int ans2 = lcsMemo(str1, str2, n, m-1, dp);
            dp[n][m] = Math.max(ans1, ans2);
        }
        return dp[n][m];
    }

    public static int lcsTab(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
        return dp[n][m];
    }

    public static int longestCommSubstring(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return ans;
    }

    public static int lis(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }
        int arr2[] = new int[set.size()];
        int idx = 0;
        for(Integer elem: set) {
            arr2[idx] = elem;
            idx++;
        }
        Arrays.sort(arr2);

        int n = arr.length;
        int m = arr2.length;
        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(arr[i-1]==arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int editDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = i;
        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    int ans3 = dp[i-1][j-1];
                    dp[i][j] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
                }
            }
        }

        return dp[n][m];
    }

    public static int strConversion(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = i;
        }
        for(int j=0; j<dp[0].length; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    int add = dp[i][j-1]; 
                    int del = dp[i-1][j];
                    dp[i][j] = Math.min(add, del) + 1;
                }
            }
        }

        return dp[n][m];
    }

    public static int strConversion2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int lcs = dp[n][m];
        int del = n-lcs;
        int add = m-lcs;
        return add + del;
    }

    public static void main(String[] args) {
        // int n=5;
        // int dp[] = new int[n+1];
        // System.out.println(fib(n, dp));
        // System.out.println(fibTabulation(n));

        // int n=5;
        // int dp[] = new int[n];
        // System.out.println(climbingStairs(n, dp));

        // int ways[] = new int[n+1];
        // Arrays.fill(ways, -1);
        // System.out.println(climbingStairs1(n, ways));
        // System.out.println(climbingStairsTab(n));

        // int val[] = {15,14,10,45,30};
        // int wt[] = {2,5,1,3,4};
        // int W = 7;
        // System.out.println(knapsack1(val, wt, W, 0, 0, 0));

        // int dp[][] = new int[val.length+1][W+1];
        // for(int i=0; i<dp.length; i++) {
        //     for(int j=0; j<dp[0].length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(knapsack(val, wt, W, val.length, dp));

        // System.out.println(knapsackTab(val, wt, W));

        // int nums[] = {4,2,7,1,3};
        // int target = 10;
        // System.out.println(subsetSum(nums, target));

        // System.out.println(unboundedKnapsack(val, wt, W));

        // int coins[] = {1,2,3};
        // int sum = 4;
        // int coins[] = {2,5,3,6};
        // int sum = 10;
        // System.out.println(coinChange(coins, sum));

        // int length[] = {1,2,3,4,5,6,7,8};
        // int price[] = {1,5,8,9,10,17,17,20};
        // int length[] = {1,3,5};
        // int price[] = {1,8,10};
        // int rodLength = 8;
        // System.out.println(rodCutting(length, price, rodLength));

        // String str1 = "abcde";
        // String str2 = "ace";
        // String str1 = "abcdge";
        // String str2 = "abedg";
        // System.out.println(longestCommSubseq(str1, str2, new StringBuilder(), 0, 0, 0));
        // System.out.println(lcs(str1, str2, str1.length(), str2.length()));

        // int dp[][] = new int[str1.length()+1][str2.length()+1];
        // for(int i=0; i<dp.length; i++) {
        //     for(int j=0; j<dp[0].length; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(lcsTab(str1, str2));

        // String str1 = "ABCDE";
        // String str2 = "ABGCE"; // 2 "AB"
        // String str1 = "ABCDGH";
        // String str2 = "ACDGHR";
        // System.out.println(longestCommSubstring(str1, str2));

        // int arr[] = {50,3,10,7,40,80};
        // System.out.println(lis(arr));

        // String word1 = "intention";
        // String word2 = "execution";
        // String word1 = "abc";
        // String word2 = "sdbat";
        // System.out.println(editDistance(word1, word2));

        // String str1 = "pear";
        // String str2 = "sea";
        // String str1 = "abcdef";
        // String str2 = "aceg";
        // System.out.println(strConversion(str1, str2));
        // System.out.println(strConversion2(str1, str2));
    }
}
