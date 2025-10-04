import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        // Step 1: Add all intervals + newInterval, then sort them by start time
        for (int[] interval : intervals) {
            list.add(interval);
        }
        list.add(newInterval);
        
        list.sort((a, b) -> a[0] - b[0]); // Sort by start

        // Step 2: Apply the "merge intervals" logic
        List<int[]> result = new ArrayList<>();
        int[] current = list.get(0);
        
        for (int i = 1; i < list.size(); i++) {
            int[] next = list.get(i);
            
            if (next[0] <= current[1]) {
                // Overlapping — merge them
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap — push current to result
                result.add(current);
                current = next;
            }
        }

        // Step 3: Add last interval
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}
