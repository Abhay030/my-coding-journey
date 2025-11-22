class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
        if(s1.length() > s2.length()) return new ArrayList<>();

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int window = s1.length();
        List<Integer> idx = new ArrayList<>();

        for(int i = 0; i < s2.length(); i++){
            freq2[s2.charAt(i) - 'a']++;

            if(i >= window){
                freq2[s2.charAt(i - window) - 'a']--;
            }

            if(Arrays.equals(freq1 , freq2)) {
                idx.add((i-window)+1);
            };

        }

        return idx;
        
    }
}