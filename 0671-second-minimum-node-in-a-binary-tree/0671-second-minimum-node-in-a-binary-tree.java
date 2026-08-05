/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> q=new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        inorder(root);
        int size=q.size();
        if(size<2){
            return -1;
        }
        Collections.sort(q);
        int largest = q.get(0);
        int ans = -1;

        for (int i = 1; i < size ; i++) {
            if (q.get(i) != largest) {
                ans = q.get(i);
                break;
            }
        }
        return ans;
    }
    public void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.left);
        q.add(root.val);
        inorder(root.right);
    }
}