class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int maxi = 0;
        HashMap<Integer , Integer> freq = new HashMap<>();

        for(int i = 0; i < fruits.length; i++){
            int num = fruits[i];
            freq.put(num , freq.getOrDefault(num , 0) + 1);

            while(freq.size() > 2){
                freq.put(fruits[left], freq.get(fruits[left])-1);
                if(freq.get(fruits[left]) == 0){
                    freq.remove(fruits[left]);
                }
                left++;
            }

            maxi = Math.max(maxi , (i-left+1));
        }

        return maxi;
    }
}