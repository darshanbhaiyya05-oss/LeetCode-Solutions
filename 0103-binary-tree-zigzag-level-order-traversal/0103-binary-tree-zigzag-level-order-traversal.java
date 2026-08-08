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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean L2R=true;
        while(!q.isEmpty()){
            int size=q.size();
            Integer[] level=new Integer[size];
            for(int i=0;i<size;i++){
                TreeNode node=q.remove();
                int idx=L2R ? i :  size-1-i;
                level[idx] = node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            L2R=!L2R;
            res.add(Arrays.asList(level));
        }
        return res;

    }
}