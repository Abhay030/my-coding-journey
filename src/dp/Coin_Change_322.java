package dp;

    class Coin_Change_322 {
        public int coinChange(int[] coins, int amount) {
            int ans = solve(coins , amount);
            if(ans == Integer.MAX_VALUE) return -1;
            return ans;

            // for solve2
//            int[] dp = new int[amount + 1];
//            Arrays.fill(dp, -1);
//            int ans = solve2(coins, dp, amount);
//            return (ans == Integer.MAX_VALUE) ? -1 : ans;
        }

        // Solved through normal recursion
        public int solve(int[] coins , int amt){
            if(amt == 0) return 0;

            if(amt < 0){
                return Integer.MAX_VALUE;
            }
            int min = Integer.MAX_VALUE;

            for(int i = 0; i<coins.length; i++){
                int ans = solve(coins , amt-coins[i]);
                if(ans != Integer.MAX_VALUE)  min = Math.min(min , 1+ans);
            }

            return min;
        }

        public int solve2(int[] coins, int[] dp, int amount) {
            // base case hits --> when the amount decreases to 0.
            if (amount == 0) return 0;
            if (amount < 0) return Integer.MAX_VALUE;

            // Checking if the ans exists already
            if (dp[amount] != -1) return dp[amount];

            // Iterate over the coins array and saving each ans if the ans is not Integer.MAX_VALUE --> which shows that ans does not exists for that amount.
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int ans = solve2(coins, dp, amount - coins[i]);
                if (ans != Integer.MAX_VALUE) {
                    min = Math.min(min, ans + 1);
                }
            }
            // min coins needed is stored at the last index of the array
            dp[amount] = min;
            return dp[amount];
        }

        public static void main(String[] args) {
            Coin_Change_322 sol = new Coin_Change_322();

            int[] coins1 = {1, 2, 5};
            int amount1 = 11;
            System.out.println("Minimum coins needed: " + sol.coinChange(coins1, amount1)); // Expected: 3

            int[] coins2 = {2};
            int amount2 = 3;
            System.out.println("Minimum coins needed: " + sol.coinChange(coins2, amount2)); // Expected: -1
        }
    }

