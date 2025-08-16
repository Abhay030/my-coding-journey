class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        int merged[] = new int[m+n];
        int idx = 0;

        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                merged[idx] = nums1[i];
                i++;
            }
            else{
                merged[idx] = nums2[j];
                j++;
            }
            idx++;
        }

        while(j < n) {
            merged[idx] = nums2[j];
            idx++;
            j++;
        }
        while(i < m) {
            merged[idx] = nums1[i];
            idx++;
            i++;
        }

        for(int ptr = 0; ptr < m+n; ptr++){
            nums1[ptr] = merged[ptr];
        }
    }
}