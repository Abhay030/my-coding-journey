class Solution {
    public int matchPlayersAndTrainers(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);

        int l = 0 , r = 0;

        while(l < m && r < n){
            if(g[r] <= s[l]){
                r = r +1;
            }
            l = l + 1;
        }
        return r;
    }
}