class Solution {
    public boolean isPalindrome(String str) {
        // return solve1(str);
        return solve2(str);
    }

    private boolean solve1(String str){
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }

        // 2. Create the reversed string
        String original = sb.toString();
        String reversed = sb.reverse().toString();

        // 3. Compare content using .equals()
        return original.equals(reversed);
    }

    private boolean solve2(String str){
        int left = 0;
        int right = str.length()-1;
        str = str.toLowerCase();

        while(left < right){
            if(!Character.isLetterOrDigit(str.charAt(left))){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(str.charAt(right))){
                right--;
                continue;
            }
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else {
                return false;
            }
        }

        return true;
    }
}