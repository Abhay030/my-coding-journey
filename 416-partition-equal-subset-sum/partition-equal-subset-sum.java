class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        int n = nums.length;
        for(Integer num : nums){
            target += num;
        }
        if(target % 2 != 0) return false;

        int[][] dp = new int[n][target+1];
        for(int i = 0; i<n; i++) Arrays.fill(dp[i] , -1);
        return canPartition(nums , n-1, target/2 , dp);
    }

    private boolean canPartition(int[] nums , int n , int target , int[][] dp){
        if( target == 0 ) return true;
        if( n == -1) return false;

        if(dp[n][target] != -1) return dp[n][target] == 1;

        boolean res;
        if(target >= nums[n]){
            res =  canPartition(nums , n-1 , target - nums[n] , dp) || canPartition(nums , n-1 , target+0 , dp);
        }
        else res = canPartition(nums , n-1 , target , dp);

        dp[n][target] = res ? 1 : 0;
        return res;
    }
}