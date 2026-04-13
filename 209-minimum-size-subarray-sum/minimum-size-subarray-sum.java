class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int mini = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                mini = Math.min(mini , (i-left+1));
                sum -= nums[left];
                left++;
            }
        }
        return mini == Integer.MAX_VALUE ? 0 : mini;
    }
}