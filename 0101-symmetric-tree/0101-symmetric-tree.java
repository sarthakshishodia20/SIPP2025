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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return true;
        }
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            TreeNode Left=q.poll();
            TreeNode Right=q.poll();
            if(Left==null && Right==null){
                continue;
            }
            if(Left==null || Right==null){
                return false;
            }
            else if(Left.val!=Right.val){
                return false;
            }
            q.add(Left.left);
            q.add(Right.right);
            q.add(Left.right);
            q.add(Right.left);
        }
        return true;
    }
}