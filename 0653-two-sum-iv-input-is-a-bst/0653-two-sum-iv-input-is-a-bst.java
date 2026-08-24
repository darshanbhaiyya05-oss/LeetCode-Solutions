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
    
    public ArrayList<Integer> arr;
    public boolean findTarget(TreeNode root, int k) {
        
        arr=new ArrayList<>();

        preorder(root);

        for(int i=0;i<arr.size();i++){
            for(int j=i+1;j<arr.size();j++){
                if(arr.get(i)+arr.get(j)==k) return true;
            }
        }
        return false;
    }
    public void preorder(TreeNode root){
        if(root==null) return ;

        preorder(root.left);
        arr.add(root.val);
        preorder(root.right);
    }
}