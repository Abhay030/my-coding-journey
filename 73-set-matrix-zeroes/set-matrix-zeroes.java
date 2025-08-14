class Solution {
    public void setZeroes(int[][] matrix) {
        // no.of rows
        int m = matrix.length;
        // no. of columns
        int n = matrix[0].length;

        // to keep recors of the 0 
        int[] row = new int[m];
        int[] column = new int[n];

        // find zero and mark it in the row and colmumn array
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        // fill the rows and columns wherever we find 0
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(row[i] == 1 || column[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }

        // Time: \U0001d442(\U0001d45a×\U0001d45b) — two full passes over the matrix.
        // Space: \U0001d442(\U0001d45a+\U0001d45b)— extra arrays row[m] and column[n].
        
    }
}