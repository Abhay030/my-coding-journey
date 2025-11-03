class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        if (n <= 1) return 0;

        int time = 0;
        int i = 1;

        while (i < n) {
            int prev = i - 1;
            if (colors.charAt(i) == colors.charAt(prev)) {
                // remove the smaller of the two; keep the larger for future comparisons
                time += Math.min(neededTime[i], neededTime[prev]);
                neededTime[i] = Math.max(neededTime[i], neededTime[prev]);
            }
            i++;
        }

        return time;
    }
}
