package dp;
import java.util.Arrays;

public class cut_into_segments {

    // Main method
    public static void main(String[] args) {
        System.out.println("Memoization: " + cutSegments(7, 5, 2, 2));
        System.out.println("Tabulation: " + solveByDp(7, 5, 2, 2));
        System.out.println("Optimized: " + solveByOptimized(7, 5, 2, 2));
        System.out.println("Recursion (TLE): " + solveByRecursion(7, 5, 2, 2));
    }

    // 1. ✅ Memoization
    public static int cutSegments(int n, int x, int y, int z) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = solveMemo(n, x, y, z, dp);
        return (ans < 0) ? 0 : ans;
    }

    private static int solveMemo(int n, int x, int y, int z, int[] dp) {
        if (n == 0) return 0;
        if (n < 0) return Integer.MIN_VALUE;
        if (dp[n] != -1) return dp[n];

        int a = solveMemo(n - x, x, y, z, dp) + 1;
        int b = solveMemo(n - y, x, y, z, dp) + 1;
        int c = solveMemo(n - z, x, y, z, dp) + 1;

        dp[n] = Math.max(a, Math.max(b, c));
        return dp[n];
    }

    // 2. ✅ Tabulation (Bottom-up DP)
    public static int solveByDp(int n, int x, int y, int z) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (i - x >= 0 && dp[i - x] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }
            if (i - y >= 0 && dp[i - y] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }
            if (i - z >= 0 && dp[i - z] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }
        }

        return (dp[n] < 0) ? 0 : dp[n];
    }

    // 3. ✅ Space Optimized (Still O(n), but avoids function call stack)
    public static int solveByOptimized(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            if (i - x >= 0) max = Math.max(max, dp[i - x]);
            if (i - y >= 0) max = Math.max(max, dp[i - y]);
            if (i - z >= 0) max = Math.max(max, dp[i - z]);
            if (max != Integer.MIN_VALUE) dp[i] = max + 1;
        }

        return (dp[n] < 0) ? 0 : dp[n];
    }

    // 4. Brute Force Recursion (TLE)
    public static int solveByRecursion(int n, int x, int y, int z) {
        int ans = solveRec(n, x, y, z);
        return (ans < 0) ? 0 : ans;
    }

    private static int solveRec(int n, int x, int y, int z) {
        if (n == 0) return 0;
        if (n < 0) return Integer.MIN_VALUE;

        int a = solveRec(n - x, x, y, z) + 1;
        int b = solveRec(n - y, x, y, z) + 1;
        int c = solveRec(n - z, x, y, z) + 1;

        return Math.max(a, Math.max(b, c));
    }
}
