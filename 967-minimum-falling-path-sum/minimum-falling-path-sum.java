class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];

        for(int[] rows: dp) Arrays.fill(rows , -1);
        int minSum = Integer.MAX_VALUE;

        // for(int i = 0; i < column; i++){
        //     minSum = Math.min(minSum , findPath(0 , i , matrix , dp));
        // }
        // return minSum;

        // return findPath2(matrix);

        return findPath3(matrix);
    }

    private int findPath(int row , int column , int[][] matrix , int[][] dp){
        if(column < 0 || column >= matrix[0].length){
            return Integer.MAX_VALUE;
        }

        if(row == matrix.length - 1) return matrix[row][column];

        if(dp[row][column] != -1){
            return dp[row][column];
        }


        int down = findPath(row + 1 , column , matrix , dp);
        int downLeft = findPath(row + 1 , column - 1 , matrix , dp);
        int downRight = findPath(row + 1 , column + 1, matrix , dp);

        int ans = matrix[row][column] + Math.min(down , Math.min(downLeft , downRight));

        dp[row][column] = ans;

        return ans;

    }

    private int findPath2(int[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;

        int[][] dp = new int[row][column];

        // set the base case 
        for(int j = 0; j < column; j++){
            dp[row - 1][j] = matrix[row -1][j];
        }

        // fill the states in the dp 
        for(int i = row -2; i >= 0; i--){
            for(int j = 0; j < column; j++){

                int down =  dp[i + 1][j];
                int downleft = (j > 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int downright = (j < column -1 ) ?dp[i + 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(down , Math.min(downleft , downright));
            }
        }

        // find the minimal in the first row.
        int mini = Integer.MAX_VALUE;
        for(int k = 0; k < column; k++){
            mini = Math.min(mini , dp[0][k]);
        }

        return mini;
    }

    private int findPath3(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prev = new int[m];

        // Base case: last row
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[n - 1][j];
        }

        // Build from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[m];

            for (int j = 0; j < m; j++) {
                int down = prev[j];
                int downLeft = (j > 0) ? prev[j - 1] : Integer.MAX_VALUE;
                int downRight = (j < m - 1) ? prev[j + 1] : Integer.MAX_VALUE;

                curr[j] = matrix[i][j] +
                        Math.min(down, Math.min(downLeft, downRight));
            }

            prev = curr; // move up
        }

        // Answer from first row
        int ans = Integer.MAX_VALUE;
        for (int val : prev) {
            ans = Math.min(ans, val);
        }

        return ans;
    }
}