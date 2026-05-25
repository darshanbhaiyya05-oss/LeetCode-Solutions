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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // get middle
        ListNode mid = getMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        // sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // merge sorted halves
        return merge(left, right);
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!= null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode Head1, ListNode Head2) {
        ListNode mergeLL=new ListNode(-1);
        ListNode temp=mergeLL;
        while(Head1!=null && Head2!=null){
            if(Head1.val<=Head2.val){
                temp.next=Head1;
                Head1=Head1.next;
                
            }else{
                temp.next=Head2;
                Head2=Head2.next;
                
            }
            temp=temp.next;
        }
        while(Head1!=null){
            temp.next=Head1;
            Head1=Head1.next;
            temp=temp.next;
        }
        while(Head2!=null){
            temp.next=Head2;
            Head2=Head2.next;
            temp=temp.next;
        }
        return mergeLL.next;
    }
}
