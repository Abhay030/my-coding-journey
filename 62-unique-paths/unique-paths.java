class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row , -1);
        // return totalPaths(m-1 , n-1);
        // return totalPaths1(m-1 , n-1 , dp);
        return totalPaths2(m-1 , n-1);
    }

    // pure recursion
    private int totalPaths(int row , int column , int[][] dp){
        if(row == 0 && column == 0){
            return 1;
        }
        if(row < 0 || column < 0){
            return 0;
        }

        int up = totalPaths(row - 1 , column , dp);
        int left = totalPaths(row , column - 1 , dp);

        return up + left;
    }

    // memoised solution
    private int totalPaths1(int row , int column , int[][] dp){
        if(row == 0 && column == 0){
            return 1;
        }
        if(row < 0 || column < 0){
            return 0;
        }

        if(dp[row][column] != -1) return dp[row][column];

        int up = totalPaths1(row - 1 , column , dp);
        int left = totalPaths1(row , column - 1 , dp);

        dp[row][column] =  up + left;

        return dp[row][column];
    }

    private int totalPaths2(int row , int column){
        int[][] dp = new int[row +1][column +1];
        
        // we will have only 1 way to reach to the final destination.
        // Base case.
        dp[0][0] = 1;

        for(int i = 0; i <= row; i++){
            for(int j = 0; j <= column; j++){
                if(i == 0 && j == 0) continue;
                int up = (i > 0) ? dp[i - 1][j] : 0;
                int left = (j > 0) ? dp[i][j - 1] : 0;

                dp[i][j] = up + left;
            }
        }

        return dp[row][column];

    }
}