class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row , -1);

        return mPathSum(m - 1 , n -1 , grid , dp);
    }
    
    private int mPathSum(int row , int column , int[][] grid , int[][] dp ){
        if(row == 0 && column == 0) return grid[0][0];
        if(row < 0 || column < 0 ) return (int) 1e9;

        if(dp[row][column] != -1) return dp[row][column];

        int up = mPathSum(row - 1 , column , grid , dp) + grid[row][column];
        int left = mPathSum(row , column - 1 , grid , dp) + grid[row][column];

        dp[row][column] = Math.min(up , left);

        return dp[row][column];
        
    }
}