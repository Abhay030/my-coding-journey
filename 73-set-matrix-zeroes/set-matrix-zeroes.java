class Solution {
    public void setZeroes(int[][] matrix) {
        //  setZerosBrute(matrix);
         setZerosOptimised(matrix);
    }

    private void setZerosBrute(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int[] rows = new int[n];
        int[] column = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rows[i] == 1 || column[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void setZerosOptimised(int[][] matrix){
         // no.of rows
        int m = matrix.length;
        // no. of columns
        int n = matrix[0].length;

        // to keep recors of the 0 in the firstrow and first column
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 1) Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) { firstRowZero = true; break; }
        }
        // 2) Check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) { firstColZero = true; break; }
        }

        // find zero and mark it in the 1st row and 1st colmumn in original array
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // fill the rows and columns wherever we find 0
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }


        // 5) Zero out first row/column if needed
        if (firstRowZero) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (firstColZero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }

        // Time: O(m×n) — two full passes over the matrix.
        // Space: O(1) extra space for variables of row and column
    }
}