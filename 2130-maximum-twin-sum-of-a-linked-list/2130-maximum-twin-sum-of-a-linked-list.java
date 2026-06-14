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
    public int pairSum(ListNode head) {
        //find mid
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //  reverse 2nd half
        ListNode prev=null;
        ListNode  curr=slow;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        //Max twin Sum
        int twinSum=0;
        ListNode first=head;
        ListNode second=prev;
        while(second!=null){
            twinSum=Math.max(twinSum,first.val+second.val);
            first=first.next;
            second=second.next;
        }
        return twinSum;
    }
}