package dp;

import java.util.* ;
import java.io.*;
public class Maximum_Sum_of_non_adjacent_elements {
        public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
            // Write your code here.
            int n = nums.size();
            int dp[] = new int[n];
            Arrays.fill(dp , -1);
            return solve(nums ,dp, n-1);
        }

        private static int solve(ArrayList<Integer> nums , int []dp , int n){
            // base case
            if(n < 0) return 0;
            if(n == 0) return nums.get(0);

            // checking the solution in the dp array
            if(dp[n] != -1) return dp[n];

            // there is the two condition :-
            // these two condition ensure they are not adjacent.
            // include :- if from right to left then --> n - 2.
            // exclude :- if from right to left then --> n - 1.
            // ans as given in the question we have to find the maximum sum.
            dp[n] = Math.max(solve(nums ,dp , n-2) + nums.get(n) , solve(nums , dp , n-1));

            // as we know the solution is always saved at the last index ,
            // but we are starting from the last index hence the solution will be on index 0.
            return dp[n];
        }

    private static int solveTab(ArrayList<Integer> nums){
        int n = nums.size();
        int dp[] = new int[n];
        Arrays.fill(dp , 0);

        dp[0] = nums.get(0);

        for(int i = 1; i<n; i++){
            int include = nums.get(i);
            if(i > 1) include += dp[i - 2];
            int exclude = dp[i - 1];

            dp[i] = Math.max(include, exclude);
        }

        return dp[n-1];
    }

        // Main method to test the function
        public static void main(String[] args) {
            ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3, 2, 5, 10, 7));
            int result = maximumNonAdjacentSum(nums);
            System.out.println("Maximum Non-Adjacent Sum: " + result);

//            return solveTab(nums);

        }
    }

