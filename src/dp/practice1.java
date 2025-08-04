package dp;

import java.util.Arrays;

public class practice1 {
    public static void main(String[] args) {
        System.out.println("Fibonacci is: " + helper(75));
        System.out.println("Fibonacci is: " + fib(75));
        System.out.println("Fibonacci is: " + fiboOptimised(75));
    }

    // Through memoization
    static int helper(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fibo(n , dp);
    }

    static int fibo(int n , int[] dp){
        if(n == 0 || n == 1) return n;

        if (dp[n] != -1) return dp[n];

        dp[n] = fibo(n-1 , dp) + fibo(n-2 ,dp);
        return dp[n];
    }
//-------------------------------------------

    // Through tabulation
    public static int fib(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0; //save the base case solution
        dp[1] = 1; // save the base case solution i.e if the value is 0 then ans is 0 and vice versa for 1.

        // fill the matrix to get the solution at the last index of the matrix i.e dp[n]
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    public static int fiboOptimised(int n){
        if (n <= 1) return n;

        int prev2 = 0; int prev1 = 1;
        for (int i = 2; i <= n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
