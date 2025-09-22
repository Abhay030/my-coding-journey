class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length;
        int column = matrix[0].length;


        int ans = 0;
        for(int i = 0; i<row; i++){
             ans = binarySearch(matrix[i] , target);
            if(ans != -1) return true;
        }

        return false;
    }

    public static int binarySearch(int[] array , int target){
        int l = 0;
        int r = array.length-1;

        while(l<=r){
            int mid = l + (r - l) /2;

            if(array[mid] == target){
                return mid;
            }
            else if(array[mid] > target){
                r = mid-1;
            }
            else l = mid+1;
        }

        return -1;
    }
}