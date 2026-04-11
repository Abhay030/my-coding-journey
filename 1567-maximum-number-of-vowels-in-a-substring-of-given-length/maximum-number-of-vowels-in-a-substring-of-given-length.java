class Solution {
    public int maxVowels(String s, int k) {
        return countVowel(s , k);
    }

    private int countVowel(String s , int k){
        int left = 0;
        int maxi = 0;
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }

            if(i-left +1 == k){
                maxi = Math.max(maxi , count);
                char chLeft = s.charAt(left);
                if(chLeft == 'a' || chLeft == 'e' || chLeft == 'i' || chLeft == 'o' || chLeft == 'u'){
                    count--;
                    left++;
                }
                else left++;
            }
        }

        return maxi;

    }
}