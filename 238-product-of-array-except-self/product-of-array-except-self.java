class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int ans[] = new int[nums.length];
        Arrays.fill(ans , 0);
        for(int num: nums){
            if(num == 0) continue;
            product *= num;
        }

        int hasZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) {
                ans[i] = product;
                hasZero++;
            }
            else nums[i] = product/nums[i]; 
        }
        if(hasZero > 1){
            int[] zeros = new int[nums.length];
            Arrays.fill(zeros , 0);
            return zeros;
        }

        return hasZero == 1 ? ans : nums;
    }
}