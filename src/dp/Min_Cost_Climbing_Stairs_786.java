package dp;

import java.util.*;

public class Min_Cost_Climbing_Stairs_786 {

    public int minCostClimbingStairs(int[] cost) {
        // Initialising the dp array with size n+1
        int n = cost.length;
        int[] dp = new int[n + 1];

        // Base cases: cost to reach step 0 or 1
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Filling dp array using bottom-up approach
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // Minimum cost to reach the top floor (beyond last step)
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // 🔹 Main method to test the function
    public static void main(String[] args) {
        Min_Cost_Climbing_Stairs_786 solver = new Min_Cost_Climbing_Stairs_786();

        int[] cost = {10, 15, 20};  // Example test case
        int result = solver.minCostClimbingStairs(cost);
        System.out.println("Minimum cost to reach the top: " + result);  // Expected: 15

        // Additional test
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Minimum cost to reach the top: " + solver.minCostClimbingStairs(cost2));  // Expected: 6
    }
}
