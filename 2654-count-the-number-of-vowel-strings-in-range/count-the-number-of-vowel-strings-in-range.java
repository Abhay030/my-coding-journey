class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++){
            if(isVowelString(words[i])) count++;
        }
        return count;
    }

    private boolean isVowelString(String str){
        int left = 0;
        int right = str.length()-1;

        char leftc = str.charAt(left);
        char rightc = str.charAt(right);
        if((leftc == 'a' || leftc == 'e' || leftc == 'i' || leftc == 'o' || leftc == 'u') && ((rightc == 'a' || rightc == 'e' || rightc == 'i' || rightc == 'o' || rightc == 'u'))){
            return true;
        }

        return false;
    }
}