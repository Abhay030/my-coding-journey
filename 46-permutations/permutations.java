class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        getAllPermutation(nums , 0 , ansList);
        return ansList;
    }

    public void getAllPermutation(int[] nums , int index , List<List<Integer>> ansList){
        if(index == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num : nums) list.add(num);
            ansList.add(list);
            return;
        }


        for(int i = index; i<nums.length; i++){
            swap(nums , i , index);
            getAllPermutation(nums , index + 1 , ansList);
            swap(nums , index , i);
        }
    }


    private void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
}