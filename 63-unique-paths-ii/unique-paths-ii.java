class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;

        // edge case
        if (obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[row][column];
        for(int[] rows: dp) Arrays.fill(rows , -1);
        // return totalPaths(row-1 , column-1 , obstacleGrid);
        return totalPaths1(row-1 , column-1 , obstacleGrid , dp);
    }

    // pure recursion
    private int totalPaths(int row , int column , int[][] obsG ){
        if(row == 0 && column == 0){
            return 1;
        }
        if( row < 0 || column < 0 || obsG[row][column] == 1){
            return 0;
        }

        int up = totalPaths(row - 1 , column , obsG);
        int left = totalPaths(row , column - 1 , obsG);

        return up + left;
    }
    // memoisation
    private int totalPaths1(int row , int column , int[][] obsG , int[][] dp){
        if( row < 0 || column < 0 ) return 0;
        if(obsG[row][column] == 1) return 0;
        if(row == 0 && column == 0) return 1;

        if(dp[row][column] != -1) return dp[row][column];

        int up = totalPaths1(row - 1 , column , obsG , dp);
        int left = totalPaths1(row , column - 1 , obsG  , dp);

        dp[row][column] = up + left;

        return dp[row][column];
    }
}