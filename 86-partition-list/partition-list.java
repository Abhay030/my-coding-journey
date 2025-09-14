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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;

        ArrayList<Integer> lesser = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        
        ListNode itr = head;
        while(itr != null){
            if(itr.val < x){
                lesser.add(itr.val);
            }
            else greater.add(itr.val);
            itr = itr.next;
        }
        itr = head; // reset itr
        int i = 0;

        int lsize = lesser.size();
        // int gsize = greater.size();
        while(itr != null){
            if(i < lsize){
                itr.val = lesser.get(i);
            }
            else {
                itr.val = greater.get(i - lsize);
            }
            i++;
            itr = itr.next;
        }

        return head;
    }
}