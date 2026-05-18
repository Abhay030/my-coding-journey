class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // PHASE 1: No overlapping 
        while(i < n && intervals[i][1] < newInterval[0]){

            ans.add(intervals[i]);
            i++;
        }

        // PHASE 2: Overlapping 
        while(i < n && intervals[i][0] <= newInterval[1]){

            newInterval[0] =
                Math.min(newInterval[0], intervals[i][0]);

            newInterval[1] =
                Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        ans.add(newInterval);

        // PHASE 3: Add the remaining
        while(i < n){

            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}