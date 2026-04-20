class Solution {
    public int maxDistance(int[] colors) {
        int maxi = 0;
        for(int i = 0; i < colors.length; i++){
            int num = colors[i];
            for(int j = i+1; j < colors.length; j++){
                if(colors[j] != num) maxi = Math.max(maxi , Math.abs(i-j));
            }
        }
        return maxi;
    }
}