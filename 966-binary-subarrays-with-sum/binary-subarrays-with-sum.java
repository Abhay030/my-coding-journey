class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // The number of subarrays with sum exactly equal to goal is 
        // atMost(goal) - atMost(goal - 1)
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int left = 0;
        int count = 0;
        int currentSum = 0;
        
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            // Shrink window if sum exceeds goal
            while (currentSum > goal) {
                currentSum -= nums[left];
                left++;
            }
            // All subarrays ending at 'right' starting from 'left' or further have sum <= goal
            count += right - left + 1;
        }
        return count;
    }
}