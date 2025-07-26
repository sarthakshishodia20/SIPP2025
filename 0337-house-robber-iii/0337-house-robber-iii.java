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
    class Pair {
        int rob;
        int skip;
           Pair(int rob, int skip) {
            this.rob = rob;
            this.skip = skip;
        }
    }
    public int rob(TreeNode root) {
        Pair result = dfs(root);
        return Math.max(result.rob, result.skip);
    }
    private Pair dfs(TreeNode node) {
        if (node == null) {
            return new Pair(0, 0);
        }
        Pair left = dfs(node.left);
        Pair right = dfs(node.right);
        int rob = node.val + left.skip + right.skip;
        int skip = Math.max(left.rob, left.skip) + Math.max(right.rob, right.skip);
        return new Pair(rob, skip);
    }
}
