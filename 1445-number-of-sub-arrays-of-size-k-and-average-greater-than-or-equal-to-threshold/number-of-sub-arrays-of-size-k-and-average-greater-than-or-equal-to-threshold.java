class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        return countSub(arr , k , threshold);
    }

    private int countSub(int[] arr , int k , int threshold){
        int left = 0;
        int count = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

            if(i-left+1 == k){
                if(sum/k >= threshold) count++;
                sum -= arr[left];
                left++;
            }
        }
        return count;
    }
}