class Solution {
    public void moveZeroes(int[] nums) {
        // moveZerosBrute(nums);
        moveZerosOpti(nums);
    }
    public void moveZerosBrute(int[] nums){
        int lastZero = 0;
        int count = 0;
        int n = nums.length;
        
        for(int i = 0; i<n; i++){
            if(nums[i] != 0){
                nums[lastZero++] = nums[i];
            }
            else count++;
        }

        for(int i = n-1; i >= n-count; i--){
            nums[i] = 0;
        }
    }

    public void moveZerosOpti(int[] nums){
        int lastZeroIndex = 0;
        int n = nums.length;

        for(int i= 0; i<n; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[lastZeroIndex];
                nums[lastZeroIndex] = temp;
                lastZeroIndex++;
            }
        }
    }
}