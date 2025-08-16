class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;  // nums1 ka pointer (sirf first m valid elements tak)
        int j = 0;  // nums2 ka pointer
        int idx = 0; // merged array ka index

        // merged array banayenge jisme size = m+n
        int merged[] = new int[m+n];

        // dono arrays ko ek saath traverse karke chhota element dalte jao
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                merged[idx] = nums1[i];
                i++; // nums1 pointer aage
            }
            else{
                merged[idx] = nums2[j];
                j++; // nums2 pointer aage
            }
            idx++; // merged me next index
        }

        // agar nums2 me abhi elements bache hain to dal do
        while(j < n) {
            merged[idx] = nums2[j];
            idx++;
            j++;
        }

        // agar nums1 me abhi elements bache hain to dal do
        while(i < m) {
            merged[idx] = nums1[i];
            idx++;
            i++;
        }

        // final merged array ko wapas nums1 me copy karo
        for(int ptr = 0; ptr < m+n; ptr++){
            nums1[ptr] = merged[ptr];
        }
    }
}

/*
⏱️ Time Complexity: O(m + n)  
   (dono arrays ek ek bar traverse hote hain)

\U0001f4be Space Complexity: O(m + n)  
   (extra merged[] array use kiya hai)
*/
