class Solution {
    public int minimumOperations(int[] nums) {
        int count  = 0;
        // Iterate through the array.
        for(int num: nums){
            if(num % 3 != 0) count++;
        }
        return count;
    }
}