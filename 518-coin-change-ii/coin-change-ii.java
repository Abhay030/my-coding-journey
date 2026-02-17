class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] arr: dp){
            Arrays.fill(arr , -1);
        }
        return solve(n-1 , amount , coins , dp);
    }

    private int solve(int n , int amount , int[] coins , int[][] dp){
        if(n == 0){
            if(amount % coins[n] == 0) return 1;
            else return 0;
        }

        if(dp[n][amount] != -1) return dp[n][amount];

        int notTake = 0 + solve(n-1 , amount , coins , dp);
        int take = 0;
        if(amount >= coins[n]){
            take = solve(n , amount-coins[n] , coins , dp);
        }

        return dp[n][amount] = take + notTake;
    }
}