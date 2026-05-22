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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // pos a
        ListNode curr=list1;
        for(int i=0;i<a-1;i++){   // a tak travel kr ke curr me list1 ki value store ki
            curr=curr.next;
        }
        ListNode prev=curr;
        
        //pos b
        curr=prev.next;
        for(int j=a ; j <= b ; j++){
            curr=curr.next;
        }
        ListNode after=curr;

        ListNode tail=list2;
        while(tail.next != null){
            tail=tail.next;
        }

        prev.next=list2;
        tail.next=after;

        return list1;
    }
}