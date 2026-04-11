class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        double sum = 0;
        double maxi = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            if(i-left+1 == k){
                maxi = Math.max((sum/k) , maxi);
                sum -= nums[left];
                left++;
            }
        }

        return maxi;
    }
}