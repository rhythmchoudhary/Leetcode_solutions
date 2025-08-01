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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head to simplify handling of the result list
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        int carry = 0;
        
        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            // Get the current values or 0 if the list is exhausted
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            // Sum the digits with carry
            int sum = val1 + val2 + carry;
            
            // Update carry for next iteration
            carry = sum / 10;
            
            // Create a new node with the digit value
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            // Move to next nodes if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummyHead.next;
    }
}
