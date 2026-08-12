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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>( (a,b)-> a.val-b.val);
        for(int i=0;i<lists.length;i++){
            ListNode node=lists[i];
            if(node!=null) pq.add(node);
        }
        ListNode dummy=new ListNode(0);
        ListNode  tail=dummy;
        while(!pq.isEmpty()){
            ListNode small=pq.remove();
            tail.next=small;
            tail=tail.next;
            if(small.next!=null){
                pq.add(small.next);
            }
        }
        return dummy.next;
    }
}