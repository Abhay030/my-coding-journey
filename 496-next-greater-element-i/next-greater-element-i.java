class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;

        // stack to keep track of the next greater 
        Stack<Integer> st = new Stack<>();
        // storre the next greater , if not found then -1 is as a default is saved.
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        

        // find the next grreater for all the elements in nums2
        for (int j = 0; j < nums2.length; j++) {
            while (!st.isEmpty() && nums2[j] >= st.peek()) {
                nextGreaterMap.put(st.pop() , nums2[j]);
            }
            st.push(nums2[j]);
        }

        int res[] = new int[n1]; // create next greater element array to store the NGE
        for(int i = 0; i<n1; i++){
            res[i] = nextGreaterMap.getOrDefault(nums1[i] , -1);
        }
        return res;

    }
}