class Solution {
    public int strStr(String haystack, String needle) {
        StringBuilder sb = new StringBuilder(haystack);
        for(int i = 0; i<haystack.length(); i++){
            if(sb.substring(i).startsWith(needle)) return i;
        }
        return -1;
    }
}