class Solution {
    public boolean isSubsequence(String s, String t) {
        int start = 0;
        int end = 0;

        while(start < s.length() && end < t.length()){
            char ch1 = s.charAt(start);
            char ch2 = t.charAt(end);

            if(ch1 == ch2){
                start++;
            }
            end++;
        }
        return start == s.length();
    }
}