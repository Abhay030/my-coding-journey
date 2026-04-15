class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums , k) - solve(nums, k-1);
    }

    public int solve(int[] nums , int k){
        int left = 0;
        int oddCount = 0;
        int nice = 0;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num % 2 != 0) oddCount++;

            while(oddCount > k) {
                if(nums[left] %2 != 0) oddCount--;
                left++;
            }
            nice += i-left+1;
        }

        return nice;
    }
}