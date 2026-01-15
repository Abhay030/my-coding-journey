class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row , -1);
        return totalPaths(m-1 , n-1 , dp);
    }

    private int totalPaths(int row , int column , int[][] dp){
        if(row == 0 && column == 0){
            return 1;
        }
        if(row < 0 || column < 0){
            return 0;
        }

        if(dp[row][column] != -1) return dp[row][column];

        int up = totalPaths(row - 1 , column , dp);
        int left = totalPaths(row , column - 1 , dp);

        dp[row][column] =  up + left;

        return dp[row][column];
    }
}