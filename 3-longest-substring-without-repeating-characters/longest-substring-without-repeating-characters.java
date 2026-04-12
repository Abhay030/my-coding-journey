class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxi = 0;

        HashMap<Character , Integer> freq = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq.put(ch , freq.getOrDefault(ch , 0) + 1);

            while(freq.containsKey(ch) && freq.get(ch) > 1){
                char charL = s.charAt(left);
                freq.put(charL , freq.get(charL)-1);
                left++;
            }

            maxi = Math.max(maxi , i - left+1);
        }

        return maxi;
    }
}