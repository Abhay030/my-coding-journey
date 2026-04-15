class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums , k) - solve(nums, k-1);
    }

    public int solve(int[] nums , int k){
        int left = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num % 2 != 0) k--;

            while(k < 0) {
                if(nums[left] %2 != 0) k++;
                left++;
            }

            count += i-left+1;
        }

        return count;
    }
}