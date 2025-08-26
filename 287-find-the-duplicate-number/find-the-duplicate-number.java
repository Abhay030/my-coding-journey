class Solution {
    public int findDuplicate(int[] nums) {
        // Store the numbers in the Map
        HashMap<Integer , Integer> map = new HashMap<>();
        // Tranverse in the Array to check if the number already present.
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) return nums[i]; // return dupliccate 
            map.put(nums[i] , i);
        }
        return -1;
    }
}