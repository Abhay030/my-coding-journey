class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean appeared[] = new boolean[nums.length+1];

        for(Integer num: nums){
            appeared[num] = true;
        }

        List<Integer> notfoundEle = new ArrayList<>();
        for(int i = 1; i<appeared.length; i++){
            if(!appeared[i]) notfoundEle.add(i);
        }

        return notfoundEle;
    }
}