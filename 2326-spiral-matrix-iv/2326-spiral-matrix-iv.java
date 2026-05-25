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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        int toprow = 0;
        int bottomrow = m - 1;
        int leftcol = 0;
        int rightcol = n - 1;

      
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = -1;
            }
        }

        while (toprow <= bottomrow && leftcol <= rightcol && head != null) {
            // left -> right
            for (int i = leftcol; i <= rightcol && head != null; i++) {
                mat[toprow][i] = head.val;
                head = head.next;
            }
            toprow++;

            // top -> bottom
            for (int j = toprow; j <= bottomrow && head != null; j++) {
                mat[j][rightcol] = head.val;
                head = head.next;
            }
            rightcol--;

            // right -> left
            for (int k = rightcol; k >= leftcol && head != null; k--) {
                mat[bottomrow][k] = head.val;
                head = head.next;
            }
            bottomrow--;

            // bottom -> top
            for (int l = bottomrow; l >= toprow && head != null; l--) {
                mat[l][leftcol] = head.val;
                head = head.next;
            }
            leftcol++; 
        }

        return mat;
    }
}
