class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();

        // dp initialization
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                temp.add(-1);
            }
            dp.add(temp);
        }

        // return findPath(0, 0, triangle, dp);

        return findPathOpti(triangle);
    }

    private int findPath(int row, int column, List<List<Integer>> triangle, List<List<Integer>> dp) {

        // base case: last row
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(column);
        }

        if (dp.get(row).get(column) != -1)
            return dp.get(row).get(column);

        int down = findPath(row + 1, column, triangle, dp);
        int downright = findPath(row + 1, column + 1, triangle, dp);

        int minSum = triangle.get(row).get(column) + Math.min(down, downright);
        dp.get(row).set(column, minSum);

        return minSum;
    }

    private int findPathOpti(List<List<Integer>> triangle){
        int n = triangle.size();

        // 1D DP initialized with last row
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        // bottom-up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j)
                        + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}
