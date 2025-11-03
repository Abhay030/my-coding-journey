class Solution {
    public int minCost(String colors, int[] neededTime) {
        // return minCost1(colors , neededTime);
        return minCost2(colors , neededTime);
    }

    public int minCost1(String colors , int[] neededTime){
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


    public int minCost2(String colors, int[] neededTime) {
        int n = colors.length();
        if (n <= 1) return 0;

        int totalTime = 0;
        int prevMax = neededTime[0]; // keep track of the max time in current same-color group

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // Add the smaller one to total
                totalTime += Math.min(prevMax, neededTime[i]);
                // Update prevMax to the one that remains (the larger one)
                prevMax = Math.max(prevMax, neededTime[i]);
            } else {
                // new color starts, reset max
                prevMax = neededTime[i];
            }
        }

        return totalTime;
    }
}
