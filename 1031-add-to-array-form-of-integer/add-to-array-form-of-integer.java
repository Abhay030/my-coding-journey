import java.util.*;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i]; 
                i--;
            }
            
            list.add(k % 10); // Take the last digit of the current sum
            k /= 10;          // Carry the rest forward to the next position
        }

        Collections.reverse(list);
        return list;
    }
}