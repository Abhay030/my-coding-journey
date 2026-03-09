class Solution {
    public boolean validPalindrome(String str) {
        return solve2(str);
    }

    private boolean solve2(String str){
        int left = 0;
        int right = str.length()-1;


        while(left < right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else{
                return isPalinDrome(str , left+1 , right) || isPalinDrome(str , left , right -1);
            }
        } 

        return true;
    }

    private boolean isPalinDrome(String str , int left , int right){
        if(left < str.length() && right >= 0){
            while(left < right){
                if(str.charAt(left) != str.charAt(right)){
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }
}