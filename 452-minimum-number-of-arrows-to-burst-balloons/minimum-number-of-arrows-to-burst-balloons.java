class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points , (a , b) -> Integer.compare(a[0], b[0]));

        int[] current = points[0];

        int arrows = 1;
        for(int i = 1; i<points.length; i++){
            int[] next = points[i];

            if(next[0] <= current[1]){
                current[1] = Math.min(current[1] , next[1]);
            }
            else{
                arrows++;
                current = next;
            }
        }

        return arrows;
    }
}