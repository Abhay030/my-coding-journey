class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] arr: dp){
            Arrays.fill(arr , -1);
        }
        // return solve(n-1 , amount , coins , dp);

        return solve2(coins , amount);


    }

    // memosied solution
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

    private int solve2(int[] coins , int amount){
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int t = 0; t <= amount; t++){
            if(t % coins[0] == 0) dp[0][t] = 1;
            else dp[0][t] = 0;
        }

        for(int i = 1; i < n; i++){
            for(int t = 0; t <= amount; t++){
                int notTake = dp[i-1][t];
                int take = 0;
                if(t >= coins[i]){
                    take = dp[i][t-coins[i]];
                }
                dp[i][t] = take + notTake;
            }
        }

        return dp[n-1][amount];
    }
}