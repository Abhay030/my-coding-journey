class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        // checking including he current element will increase the overall sum 
        //  if yes then include otherwise exclude
        int bestEndingHere = nums[0];
		int bestSoFar = nums[0];
		for (int i = 1; i < n; i++) {
			bestEndingHere = Math.max(nums[i], bestEndingHere + nums[i]);
			bestSoFar = Math.max(bestSoFar, bestEndingHere);
		}
		return bestSoFar; 
    }
}