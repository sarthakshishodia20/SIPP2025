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
    public boolean isSameTree(TreeNode p, TreeNode Q) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(p);
        q.add(Q);
        while(!q.isEmpty()){
            TreeNode first=q.poll();
            TreeNode second=q.poll();
            if(first==null && second==null){
                continue;
            }
            else if(first==null || second==null || first.val!=second.val){
                return false;
            }
            q.add(first.left);
            q.add(second.left);
            q.add(first.right);
            q.add(second.right);
        }
        return true;
    }
}