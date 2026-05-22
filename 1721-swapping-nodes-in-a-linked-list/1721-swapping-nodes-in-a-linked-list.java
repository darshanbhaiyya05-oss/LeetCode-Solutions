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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        int size = 0;

        // find size
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int pos2 = size - k + 1;

        int i = 1;
        curr = head;
        ListNode node1 = null, node2 = null;

        // find kth and (n-k+1)th nodes
        while (curr != null) {
            if (i == k) node1 = curr;
            if (i == pos2) node2 = curr;
            curr = curr.next;
            i++;
        }

        // swap values
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;

        return head;
    }
}