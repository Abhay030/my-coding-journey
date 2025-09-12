class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        // return bruteforce(order , friends);

        return optimised(order , friends);
    }
    
    private static int[] bruteforce(int[] order, int[] friends){
        int ans[] = new int[friends.length];
        int index = 0;
        for(int i = 0; i<order.length; i++){
            for(int j = 0; j<friends.length; j++){
                if(order[i] == friends[j]){
                    ans[index] = order[i];
                    index++;
                    break;
                }
            }
        }

        return ans;
    }

    private static int[] optimised(int[] order, int[] friends){
        Set<Integer> participated = new HashSet<Integer>();
        int size = friends.length;
        int ans[] = new int[size];

        // store the friends who participated in the race.
        for(Integer num: friends){
            participated.add(num);
        }

        // find their finishing order by linear search
        int index = 0;
        for(int n : order){
            if(participated.contains(n)){
                ans[index] = n;
                index++;
            } 
        }

        return ans;

    }
}