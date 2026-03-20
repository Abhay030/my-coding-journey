class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralM = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0, left = 0;
        int right = m-1;
        int bottom = n-1;

        while(left <= right && top <= bottom){
            for(int i = left; i<= right; i++){
            spiralM.add(matrix[top][i]);
        }
        top++;
        
        for(int i = top; i <= bottom; i++){
            spiralM.add(matrix[i][right]);
        }
        right--;

        if(top <= bottom){
            for(int i = right; i >= left; i--){
                spiralM.add(matrix[bottom][i]);
            }
        }
        bottom--;

        if(left <= right){
            for(int i = bottom; i >= top; i--){
                spiralM.add(matrix[i][left]);
            }
        }
        left++;
        }

        return spiralM;

    }
}