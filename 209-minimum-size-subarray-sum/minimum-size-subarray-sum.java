class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        while (end < nums.length) {
            sum += nums[end];
            end++;

            while (sum >= target) {
                minLen = Math.min(minLen, end - start); 
                sum -= nums[start];
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}