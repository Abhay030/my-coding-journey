class Solution {
    public int[][] merge(int[][] intervals) {
        // step 1 sort the intervals on the start time basis
        Arrays.sort(intervals , (a , b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // step2 : initialise with the start interval
        int[] current = intervals[0];


        // step3: iterate the find the overlap , (if yes) then merge otherwise set current and move on.
        for(int i = 1; i<intervals.length; i++){
            int[] next = intervals[i];

            // check for the overlap.
            if(next[0] <= current[1]){
                current[1] = Math.max(current[1] , next[1]);
            }
            else{
                result.add(current);
                current = next;
            }
        }
        
        // step4: add the last interval
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}