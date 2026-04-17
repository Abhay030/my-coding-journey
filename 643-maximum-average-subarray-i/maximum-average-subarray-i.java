class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        double maxi = Integer.MIN_VALUE;
        double sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if((i-left+1) == k){
                maxi = Math.max(maxi , (sum)/k);
                sum -= nums[left];
                left++;
            }
        }

        return maxi;
    }
}