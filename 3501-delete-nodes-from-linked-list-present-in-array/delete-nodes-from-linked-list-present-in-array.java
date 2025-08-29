/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {

        Set<Integer>  toDelete = new HashSet<>();
        // save what to delete in the set.
        for(int num: nums){
            toDelete.add(num);
        }

        // make the dummy node to handle the head deletions.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // pointer to iterate over the list 
        ListNode itr = dummy;

        while(itr.next != null){
            if(toDelete.contains(itr.next.val)){
                // itr.val = itr.next.val;
                itr.next = itr.next.next;          
            }
            else itr = itr.next;
        }

        return dummy.next;
    }
}