class Solution {
    public int removeDuplicates(int[] nums) {
        int putAt = 1;
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[putAt] = nums[i];
                putAt++;
                count++;
            }
        }

        return count+1;
        
    }
}