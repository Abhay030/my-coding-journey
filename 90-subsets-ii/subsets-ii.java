class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    HashSet<List<Integer>> map = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        createPowerSet(0, nums, new ArrayList<>());

        return new ArrayList<>(map);
    }

    private void createPowerSet(
        int index,
        int[] nums,
        List<Integer> current
    ) {

        if(index == nums.length){

            map.add(new ArrayList<>(current));

            return;
        }

        createPowerSet(index+1, nums, current);

        current.add(nums[index]);

        createPowerSet(index+1, nums, current);

        current.remove(current.size()-1);
    }
}