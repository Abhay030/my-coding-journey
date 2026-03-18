class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        
        int count = 0;
        long prev = Long.MAX_VALUE; 
        int result = nums[nums.length - 1]; 
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < prev) {
                count++;
                prev = nums[i];
                if (count == 3) return nums[i]; // found 3rd distinct max
            }
        }
        
        return result; 
    }
}