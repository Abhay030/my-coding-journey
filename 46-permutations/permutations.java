class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> anslist = new ArrayList<>();
        backtrack(nums, 0, anslist);
        return anslist;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> anslist) {
        // Base case: agar index end tak pahunch gaya
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            anslist.add(temp);
            return;
        }

        // Har element ko index position par fix karo
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);

            // Recursively next index ke liye call
            backtrack(nums, index + 1, anslist);

            // Backtrack: swap wapas
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
