class Solution {
    // int maxi = 0;
    public int maxSumDivThree(int[] nums) {
        // return helper(nums , 0 , nums.length-1 );

        Integer[][] dp = new Integer[nums.length][3];
        return helper(nums , 0 , 0 , dp);
    }

    // recursive
    public int helper(int[] nums , int sum , int i ){
        if(i < 0){
            if(sum % 3 == 0){
                return sum;
            }
            return 0;
        }


        return Math.max(helper(nums , sum + nums[i] , i-1 ) , helper(nums , sum , i - 1));
    }
    // revcursive + memp
    public int helper(int[] nums , int i , int rem , Integer[][] dp){
        if(i == nums.length){
            return rem == 0 ? 0 : Integer.MIN_VALUE;
        }

        if(dp[i][rem] != null) return dp[i][rem];

        int include = nums[i] + helper(nums , i + 1 , (rem + nums[i]) % 3 , dp);
        int exclude = helper(nums , i + 1 , rem , dp);

        dp[i][rem] = Math.max(include, exclude);

        return dp[i][rem];
    }
}