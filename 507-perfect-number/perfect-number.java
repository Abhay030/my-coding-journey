class Solution {
    public boolean checkPerfectNumber(int num) {
        int ans = 0;
        for(int i = 1; i*2 <= num; i++){
            if(num%i == 0) ans += i;
        }
        return ans == num;
    }
}