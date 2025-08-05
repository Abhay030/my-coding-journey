package dp;

import java.util.* ;
import java.io.*;

public class Maximum_Sum_of_non_adjacent_elements {

    public int rob(int[] nums) {
        int n = nums.length;

        // Creating a dp array of size n to store solutions to subproblems
        int dp[] = new int[n];
        Arrays.fill(dp, -1); // Initializing dp array with -1 (indicates uncomputed)

        // You can switch between different approaches by uncommenting the desired method:
        // return solveByRecursion(nums , n-1);         // Recursive approach (no memoization)
        // return solveByDp(nums , dp , n-1);           // Top-down DP with memoization
        // return solveByBottomUp(nums);                // Bottom-up DP with tabulation
        return memoryOptimised(nums);                  // Bottom-up DP with space optimization
    }

    // ------------------------- 1. Recursive Solution (No DP) -------------------------
    private int solveByRecursion(int nums[], int n) {
        // Base case: if index is out of bounds (before start), return 0
        if (n < 0) return 0;

        // Base case: if only one element, return it
        if (n == 0) return nums[0];

        // Include current element and solve for n-2 (ensures non-adjacency)
        int include = solveByRecursion(nums, n - 2) + nums[n];

        // Exclude current element and solve for n-1
        int exclude = solveByRecursion(nums, n - 1);

        // Return maximum of include and exclude
        return Math.max(include, exclude);
    }

    // --------------------- 2. Top-Down DP (Memoization) ---------------------
    private int solveByDp(int nums[], int dp[], int n) {
        // Base case: out of bounds, return 0
        if (n < 0) return 0;

        // Base case: if only one element, return it
        if (n == 0) return nums[0];

        // Check whether the solution exists in the dp array or not
        if (dp[n] != -1) return dp[n];

        // Include current element (non-adjacent jump by 2)
        int include = solveByDp(nums, dp, n - 2) + nums[n];

        // Exclude current element (move to previous)
        int exclude = solveByDp(nums, dp, n - 1);

        // Store and return the maximum of both choices
        dp[n] = Math.max(include, exclude);

        return dp[n];
    }

    // ------------------------- 3. Bottom-Up DP (Tabulation) -------------------------
    private int solveByBottomUp(int nums[]) {
        int n = nums.length;

        // dp[i] represents the maximum sum we can get from index 0 to i
        int dp[] = new int[n];

        // Base initialization: only one element to pick
        dp[0] = nums[0];

        // Iteratively build the dp table
        for (int i = 1; i < n; i++) {
            int include = nums[i];            // If we include current element
            if (i > 1) include += dp[i - 2];  // Add dp[i-2] if within bounds

            int exclude = dp[i - 1];          // Exclude current element

            // Store the maximum of include and exclude
            dp[i] = Math.max(include, exclude);
        }

        // The last cell contains the final answer
        return dp[n - 1];
    }

    // ------------------------- 4. Optimized Space Solution -------------------------
    private int memoryOptimised(int nums[]) {
        int n = nums.length;

        // prev2 = dp[i-2], prev1 = dp[i-1]
        int prev2 = 0;
        int prev1 = nums[0]; // Only one element at index 0

        // Iterate from second element to the end
        for (int i = 1; i < n; i++) {
            int include = prev2 + nums[i]; // Include current, add prev2
            int exclude = prev1;           // Exclude current, take prev1

            int ans = Math.max(include, exclude); // Max of include/exclude

            // Update prev2 and prev1 for next iteration
            prev2 = prev1;
            prev1 = ans;
        }

        // Final answer is in prev1 (like dp[n-1])
        return prev1;
    }
}


//✅ Summary of Approaches in Your Code:
//Method	Technique	Time Complexity	Space Complexity
//solveByRecursion	Pure recursion	O(2^n)	O(n) (call stack)
//solveByDp	Top-down DP	O(n)	O(n)
//solveByBottomUp	Bottom-up DP	O(n)	O(n)
//memoryOptimised	Space-optimized	O(n)	O(1)