import java.util.*;

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

    public static void main(String[] args) {
        // int n=5;
        // int dp[] = new int[n+1];
        // System.out.println(fib(n, dp));
        // System.out.println(fibTabulation(n));

        int n=5;
        // int dp[] = new int[n];
        // System.out.println(climbingStairs(n, dp));

        // int ways[] = new int[n+1];
        // Arrays.fill(ways, -1);
        // System.out.println(climbingStairs1(n, ways));
        System.out.println(climbingStairsTab(n));
    }
}
