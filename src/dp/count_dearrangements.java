package dp;
import java.util.Arrays;

public class count_dearrangements {
        // MOD constant rakha hai taaki hum large numbers ko modulo karke rakhein
        private static final long MOD = 1_000_000_007L;

        public static long countDerangements(int n) {
            // Agar DP (Top-Down / Memoization) use karna ho:
            // long dp[] = new long[n+1];                  // dp array banaya size n+1
            // Arrays.fill(dp , -1);                       // saare values -1 set kiya (uncomputed)
            // return solveByDp(n , dp);                   // memoized recursive call

            // Abhi hum Tabulation (Bottom-Up) approach call kar rahe hain
            // return solveByTab(n);
            return solveByOpti(n);
        }

        // =================== DP (Memoization) Approach ===================
        private static long solveByDp(int n , long dp[]) {
            // Base case: D(0) = 1
            if (n == 0) return 1;
            // Base case: D(1) = 0
            if (n == 1) return 0;

            // Agar dp[n] already calculated hai to wahi return kar do
            if (dp[n] != -1) return dp[n];

            // Recursive calls: Derangement formula
            // dhyan: yahaan galti hai ? countDerangements ko call karne se har baar naya tabulation start hoga
            // ideally solveByDp(n-1, dp) aur solveByDp(n-2, dp) call karna chahiye
            long a = countDerangements(n - 1) % MOD;
            long b = countDerangements(n - 2) % MOD;

            // Formula: D(n) = (n-1) * (D(n-1) + D(n-2)) % MOD
            dp[n] = ((n - 1) * ((a + b) % MOD)) % MOD;
            return dp[n];
        }

        // =================== Tabulation (Bottom-Up) Approach ===================
        private static long solveByTab(int n) {
            long dp[] = new long[n + 1];
            Arrays.fill(dp , -1); // Yahaan -1 fill karna optional hai, kyunki hum 0 se overwrite kar rahe

            // Base cases
            dp[0] = 1;  // D(0) = 1
            dp[1] = 0;  // D(1) = 0

            // Loop se dp fill karte hain bottom-up
            for (int i = 2; i <= n; i++) {
                long a = dp[i - 1] % MOD; // D(i-1)
                long b = dp[i - 2] % MOD; // D(i-2)

                // Formula apply
                dp[i] = ((i - 1) * ((a + b) % MOD)) % MOD;
            }

            return dp[n]; // answer return
        }

        // =================== Space Optimized Approach ===================
        private static long solveByOpti(int n) {
            // Base cases directly handle
            if (n == 0) return 1;
            if (n == 1) return 0;

            long prev2 = 1; // D(0)
            long prev1 = 0; // D(1)

            // Only 2 variables maintain karke space O(1) me kaam karenge
            for (int i = 2; i <= n; i++) {
                long curr = ((i - 1) * ((prev1 + prev2) % MOD)) % MOD;
                prev2 = prev1;
                prev1 = curr;
            }

            return prev1; // final result
        }

    public static void main(String[] args) {
        count_dearrangements sol = new count_dearrangements();
        System.out.println(sol.countDerangements(4)); // 9 expected
    }
}
