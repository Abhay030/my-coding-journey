class Solution {
    public int firstUniqChar(String s) {
        // int[] freq = new int[26];

        // for(int i = 0; i<s.length(); i++){
        //     char ch = s.charAt(i);
        //     freq[ch - 'a']++;
        // }

        // for(int i = 0; i<s.length(); i++){
        //     char ch = s.charAt(i);
        //     if(freq[ch - 'a'] == 1) return i;
        // }

        // return -1;


        int res = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            // If it exists and is the only occurrence
            if (index != -1 && index == s.lastIndexOf(c)) {
                res = Math.min(res, index);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}