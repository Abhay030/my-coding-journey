class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();

        int l = 0 , r = 0;

        while(r < m){
            // when both of the pointers match then we will move both the pointers.
            if(l < n && name.charAt(l) == typed.charAt(r)) {
                l++;
                r++;
            }
            else if(r > 0 && typed.charAt(r) == typed.charAt(r-1)){
                r++;
            }
            else{
                return false;
            }
        }

        return l == n;
    }
}