class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // Two Pointers to manage the window size
        int left = 0 , right = 0;

        int sum = 0;
        int n = arr.length; // size of the array.
        int count = 0; // counter to store the subarrays having Average Greater than or Equal to Threshold
        while(right < n){
            sum += arr[right];

            // condition to check Average Greater than or Equal to Threshold and size == k
            if(right - left + 1 == k ){
                if((sum/k) >= threshold){
                    count++;
                }
                sum -= arr[left];
                left++;
            }

            right++;
        }

        return count;
    }
}