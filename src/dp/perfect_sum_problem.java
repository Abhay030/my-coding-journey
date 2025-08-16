package dp;

public class perfect_sum_problem {
        private static final int MOD = 1_000_000_007;

        public int perfectSum(int[] nums, int target) {
            int n = nums.length;

            int[][] dp = new int[n][target + 1];

            // Base Case Initialization
            if (nums[0] == 0) {
                dp[0][0] = 2; // take or not take 0
            } else {
                dp[0][0] = 1; // don't take anything
                if (nums[0] <= target) {
                    dp[0][nums[0]] = 1; // take nums[0]
                }
            }

            // Filling the DP Table
            for (int i = 1; i < n; i++) {
                for (int t = 0; t <= target; t++) {
                    int notTake = dp[i - 1][t];
                    int take = 0;
                    if (nums[i] <= t) {
                        take = dp[i - 1][t - nums[i]];
                    }
                    dp[i][t] = (take + notTake) % MOD;
                }
            }

            return dp[n - 1][target];
        }
}




