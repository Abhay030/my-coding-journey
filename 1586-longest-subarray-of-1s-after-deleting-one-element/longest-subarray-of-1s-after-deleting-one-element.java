class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int freq[] = new int[2];
        int maxi = 0;

        for(int i = 0; i < nums.length; i++){
            freq[nums[i]]++;

            while((i - left +1) - freq[1] > 1){
                freq[nums[left]]--;
                left++;
            }

            maxi = Math.max(maxi , (i - left + 1));
        }

        return maxi == 0 ? 0 : maxi-1;
    }
}