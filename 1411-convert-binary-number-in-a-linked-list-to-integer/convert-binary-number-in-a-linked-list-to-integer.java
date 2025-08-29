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
    public int getDecimalValue(ListNode head) {
        // example to convert into decimal
        //  String binaryString = "1101"; // The binary number as a string
        // int decimalNumber = Integer.parseInt(binaryString, 2); 

        // store into string the binary number
        String binaryString = "";
        while(head != null){
            // concat the string
            binaryString += head.val;
            head = head.next;
        }

        // return its decimal value
        return Integer.parseInt(binaryString , 2);
    }
}