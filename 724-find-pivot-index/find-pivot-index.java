class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];

        // Builds the prefixSum array.
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        // check leftSum == rightSum
        for(int i = 0; i < n; i++){
            int leftSum = (i == 0) ? 0 : prefixSum[i - 1];
            int rightSum = prefixSum[n - 1] - prefixSum[i];

            if(leftSum == rightSum) return i;
        }
        
        return -1;
    }
}