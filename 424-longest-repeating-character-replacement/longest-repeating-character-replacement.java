class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int[] freq = new int[26];
        int maxi = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq , freq[ch - 'A']);

            while((i - left + 1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxi = Math.max(maxi , (i-left+1));
        }

        return maxi;
    }
}