class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 1) return nums[0];

        // Case 1: rob houses from 0 to n-2
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = solve(nums, dp1, 0, n - 2);

        // Case 2: rob houses from 1 to n-1
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = solve(nums, dp2, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int solve(int[] nums, int[] dp, int i, int end) {
        if (i > end) return 0;
        if (dp[i] != -1) return dp[i];

        int include = nums[i] + solve(nums, dp, i + 2, end);
        int exclude = solve(nums, dp, i + 1, end);

        return dp[i] = Math.max(include, exclude);
    }
}


