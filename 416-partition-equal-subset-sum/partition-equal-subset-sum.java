class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;

        int n = nums.length;
        Boolean dp[][] = new Boolean[n][sum+1];

        return checkSum(n-1 ,  sum/2 , nums , dp);
    }

    private boolean checkSum(int n , int sum , int[] nums , Boolean[][] dp){
        if( sum == 0 ) return true;
        if(n < 0) return false;

        // each state of the dp shows that the reuired sum can be achieved from the nth index of the nums.
        if(dp[n][sum] != null) return dp[n][sum];

        boolean notake = checkSum(n - 1 , sum , nums , dp);
        boolean take = false;

        if(nums[n] <= sum){
            take = checkSum(n - 1 , sum - nums[n], nums , dp);
        } 

        dp[n][sum] = take || notake;

        return dp[n][sum];

    }
}