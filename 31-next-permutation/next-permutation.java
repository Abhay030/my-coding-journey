class Solution {
    public void nextPermutation(int[] nums) {
        int pivot  = -1;
        int n = nums.length;
        if(n == 1) return;

        for (int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                pivot  = i;
                break;
            }
        }

        if(pivot != -1){
            int j = n - 1;
            while(nums[j] <= nums[pivot]) j--;

            swap(nums , pivot , j);

            reverse(nums , pivot+1 , n-1);
        }
        else{
            reverse(nums, 0 , n-1);
            return ;
        }
    }

    private void swap(int[] nums, int pivot , int j){
        int temp = nums[pivot];
        nums[pivot] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums , int start , int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp; 
            start++;
            end--;
        }
    }

}