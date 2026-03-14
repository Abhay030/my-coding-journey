class Solution {
    public int removeElement(int[] nums, int val) {
        int putAt = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != val){
                nums[putAt] = nums[i];
                putAt++;
            }
        }
        return putAt;
    }
}