class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // int ans = minDenominations(n-1 , coins , amount);
        // if(ans >= (int)1e9) return -1;
        // return ans;

        int[][] dp = new int[n][amount+1];
        for(int[] arr: dp){
            Arrays.fill(arr , -1);
        }

        int ans = minDenominations2(n-1 , coins , amount , dp);
        if(ans >= (int)1e9) return -1;
        return ans;
    }

    // recursion logic
    private int minDenominations(int n , int[] coins ,int target){
        if(n == 0){
            if( target % coins[n] == 0) return target/coins[n];
            else return (int)1e9;
        }

        int notTake = 0 + minDenominations(n - 1 , coins , target);
        int take = (int)1e9;
        if(coins[n] <= target){
            take = 1 + minDenominations(n , coins , target - coins[n]);
        }

        return Math.min(take , notTake);
    }

    // memoised solution
    private int minDenominations2(int n , int[] coins ,int target , int[][] dp){
        if(n == 0){
            if( target % coins[n] == 0) return target/coins[n];
            else return (int)1e9;
        }

        if(dp[n][target] != -1) return dp[n][target];

        int notTake = 0 + minDenominations2(n - 1 , coins , target ,dp);
        int take = (int)1e9;
        if(coins[n] <= target){
            take = 1 + minDenominations2(n , coins , target - coins[n] ,dp);
        }

        dp[n][target] = Math.min(take , notTake);

        return dp[n][target];
    } 
}