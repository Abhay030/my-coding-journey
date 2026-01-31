class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for (int[][] arr2d : dp) {
            for (int[] arr1d : arr2d) {
                Arrays.fill(arr1d, -1);
            }
        }
        return solve(0, 0, m - 1, n, m, grid, dp);
	}

	private static int solve(int i , int j1 , int j2 , int n , int m , int[][] grid , int[][][] dp){
		// boundary check 
		if(j1 < 0 || j1 >= m || j2 >= m || j2 < 0){
			return (int)(-1e8);
		}

		// base case for last row.
		if(i == n-1){
			if(j1 == j2){
				return grid[i][j1];
			}
			else return grid[i][j1] + grid[i][j2];
		}

		// return the saved answer
		if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

		int maxi = (int)(-1e9);
        int curr = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];

		for(int dj1 = -1; dj1 <= 1; dj1++){
			for(int dj2 = -1; dj2 <= 1; dj2++){
				int ans = curr + solve(i + 1, j1 + dj1, j2 + dj2,
                                       n, m, grid, dp);
                maxi = Math.max(maxi, ans);
			}
		}

		dp[i][j1][j2] = maxi;

		return dp[i][j1][j2];

	}
}