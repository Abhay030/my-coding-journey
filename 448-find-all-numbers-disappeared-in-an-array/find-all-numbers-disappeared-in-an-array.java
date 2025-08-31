class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // to store what elements appeared 
        boolean appeared[] = new boolean[nums.length+1];

        // iterate over the array to store their existence
        for(Integer num: nums){
            appeared[num] = true;
        }

        // store not found elements by checking which element's index is false in the appeared array.
        List<Integer> notfoundEle = new ArrayList<>();
        for(int i = 1; i<appeared.length; i++){
            if(!appeared[i]) notfoundEle.add(i);
        }

        return notfoundEle;
    }
}