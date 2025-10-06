class Solution {
    public int eraseOverlapIntervals(int[][] points) {
        Arrays.sort(points , (a , b) -> Integer.compare(a[1], b[1]));

        int lastEndTime = points[0][1];
        int count = 0;

        for(int i = 1; i<points.length; i++){
            if(points[i][0] < lastEndTime){
                count++;
            }
            else{
                lastEndTime = points[i][1];
            }
        }

        return count;
    }
}