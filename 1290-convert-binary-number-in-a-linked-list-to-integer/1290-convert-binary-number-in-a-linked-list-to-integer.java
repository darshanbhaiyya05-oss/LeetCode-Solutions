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
        // int size =0;
        // while(head.next!=null){
        //     size++;
        //     head=head.next;
        // }

        int number=0;
         while (head != null) {
            number = number * 2 + head.val;
            head = head.next;
        }

        return number;
    }
}