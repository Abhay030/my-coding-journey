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
    public ListNode removeNodes(ListNode head) {
    //    return bruteForce(head);
        // return removeNodeRec(head);
        return optimisedMonoStack(head);
    }

    private static ListNode removeNodeRec(ListNode head){
        // if head is null and head.next is null then remove 
        if(head == null || head.next == null){
            return head;
        }

        head.next = removeNodeRec(head.next);

        if(head.val < head.next.val){
            return head.next; // skip the current element
        }

        return head;
    }

    private static ListNode bruteForce(ListNode head){
         Stack<ListNode> stack = new Stack<>();
        Map<ListNode , Boolean> toRemove = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode ptr = head;

        while(ptr != null){
            // pop all smaller Nodes
            while(!stack.isEmpty() && ptr.val > stack.peek().val){
                toRemove.put(stack.pop() , true);
            }
            stack.push(ptr);
            toRemove.put(ptr , false);
            ptr = ptr.next;
        }

        // Remove the marked node
        ListNode itr = dummy;
        while(itr.next != null){
            if(toRemove.get(itr.next)){
                itr.next = itr.next.next;
            }
            else{
                itr = itr.next;
            }
        }

        return dummy.next;

    }

    private static ListNode optimisedMonoStack(ListNode head){
        // store the values which we want to keep
        Stack<ListNode> stack = new Stack<>();
        ListNode ptr = head;

        // step1 : push all the value which are greater and remove the smaller once
        while(ptr != null){
            while(!stack.isEmpty() && ptr.val > stack.peek().val){
                stack.pop();
            }
            stack.push(ptr);
            ptr = ptr.next;
        }

        // step2: create the list by popping the elements from the stack
        ListNode newNode = null;    
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            node.next = newNode;
            newNode = node;
        }

        // return the new list
        return newNode;
    }
}