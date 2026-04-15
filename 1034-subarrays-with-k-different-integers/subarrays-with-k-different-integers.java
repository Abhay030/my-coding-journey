class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums , k) - solve(nums , k-1);
    }

    private int solve(int[] nums , int k){
        int left = 0;
        int count = 0;

        HashMap<Integer , Integer> ele = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            ele.put(nums[i] , ele.getOrDefault(nums[i] , 0) +1);

            while(ele.size() > k){
                ele.put(nums[left] , ele.get(nums[left])-1);
                if(ele.get(nums[left]) == 0) ele.remove(nums[left]);
                left++;
            }

            count += i-left+1;
        }

        return count;
    }
}