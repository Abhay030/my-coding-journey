class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums , 0 , new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums , int index , List<Integer> current){
        if(index == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: not take
        dfs(nums , index+1 , current);

        // Choice 2: take 
        current.add(nums[index]); // choose
        dfs(nums, index+1 , current); // explore
        current.remove(current.size() - 1); // un choose
    }
}