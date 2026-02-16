class Solution {
    public int findTargetSumWays(int[] arr, int d) {
        int n = arr.length;
        int sum = 0;
        for (int x : arr) sum += x;

        // impossible cases
        if (sum - d < 0) return 0;
        if ((sum - d) % 2 != 0) return 0;

        int target = (sum - d) / 2;

        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(n - 1, target, arr , dp);
    }

    private static int solve(int i, int target, int[] arr , int[][] dp) {

        // base case
        if (i == 0) {
            if (target == 0 && arr[0] == 0) return 2; 
            if (target == 0) return 1;
            if (target == arr[0]) return 1;
            return 0;
        }

        if (dp[i][target] != -1) return dp[i][target];


        int notTake = solve(i - 1, target, arr , dp) ;

        int take = 0;
        if (arr[i] <= target) {
            take = solve(i - 1, target - arr[i], arr , dp);
        }

        return dp[i][target] = (take + notTake) ;
    }
}