class Solution {
    public int findDuplicate(int[] nums) {
        // return usingHashMap(nums);
        return usingTwoPointer(nums);
    }

    private int usingHashMap(int[] nums){
        // Store the numbers in the Map
        HashMap<Integer , Integer> map = new HashMap<>();
        // Tranverse in the Array to check if the number already present.
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) return nums[i]; // return dupliccate 
            map.put(nums[i] , i);
        }
        return -1;
    }

    private int usingTwoPointer(int[] nums){
        int slow = nums[0];
        int fast = nums[0];

        // Detect Cycle
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);

        // set slow again to the start
        slow = nums[0];
        // iterate to find the cycle
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}