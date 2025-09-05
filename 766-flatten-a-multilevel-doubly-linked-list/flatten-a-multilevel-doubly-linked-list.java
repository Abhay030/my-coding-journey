/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        Node ptr = head;
        
        // store the node from where we have to continue the list
        Stack<Node> stack = new Stack<>();
        Node lastNode = null; // pointer to the last node of the list

        // itr and modify the child and real list relation
        while(ptr != null){
            if(ptr.child != null){
                stack.push(ptr.next);
                ptr.next = ptr.child;
                ptr.next.prev = ptr;
                ptr.child = null;
                ptr = ptr.next;
            }
            else {
                lastNode = ptr;
                ptr = ptr.next;
            }
        }

        // pop the elements and then connect the remaining list after child
        while(!stack.isEmpty()){
            Node nextNode = stack.pop();
            if(nextNode != null){
                lastNode.next = nextNode;
                nextNode.prev = lastNode;

                while(nextNode.next != null){
                    nextNode = nextNode.next;
                }
                lastNode = nextNode;
            }
        }

        return head;

    }
}