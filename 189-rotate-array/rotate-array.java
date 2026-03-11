class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; 
        if (k == 0) return;

        // 1. Store the LAST k elements in a temp array
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[n - k + i];
        }

        // 2. Shift the remaining elements to the right
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        // 3. Put the temp elements back at the start
        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}