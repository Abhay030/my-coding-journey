class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot != -1) {
            int j = n - 1;
            while (nums[j] <= nums[pivot])
                j--;

            // Swap pivot and that just-larger element
            swap(nums, pivot, j);

            // 3) Pivot ke right wale suffix ko reverse karo -> smallest possible suffix ban jayega
            reverse(nums, pivot + 1, n - 1);
        } else {
            reverse(nums, 0, n - 1);
            return;
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // Utility: reverse subarray in-place
    private void reverse(int[] a, int l, int r) {
        // l < r use karo (<= se beech wala element unnecessary swap hoga)
        while (l < r) {
            swap(a, l++, r--);
        }
    }
}

/*
⏱️ Time Complexity: O(n)
   - Pivot search O(n), just-larger search O(n) worst-case, reverse O(n), but sab linear passes hi hain.

\U0001f4be Space Complexity: O(1)
   - In-place swaps/reverse, koi extra array nahi.
*/