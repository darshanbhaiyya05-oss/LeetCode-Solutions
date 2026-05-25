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
    public static ListNode head;

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // handle edge cases
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode result;    // head of merged list
        ListNode temp;      // pointer to build the list

        // compare first heads
        if (list1.val <= list2.val) {
            result = list1;
            list1 = list1.next;
        } else {
            result = list2;
            list2 = list2.next;
        }

        temp = result;

        // merge remaining nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // attach the remaining part
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return result;
    }
}
