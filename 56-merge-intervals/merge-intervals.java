class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1 :- sort with starting interval
        Arrays.sort(intervals ,(a,b) -> a[0] - b[0]);
        // To store the final resultant array   
        List<int[]> ans = new ArrayList<>();

        int[] current = intervals[0];

        for(int i = 1; i<intervals.length; i++){
            int[] next = intervals[i];
            
            // if the interval overlapps then merge it -->
            if(next[0] <= current[1]){
                current[1] = Math.max(next[1] , current[1]);
            }
            // no overlapp
            else {
                ans.add(current);
                current = next;
            }
        }

        // add the last interval as well
        ans.add(current);

        return ans.toArray(new int[ans.size()][]);

    }
}