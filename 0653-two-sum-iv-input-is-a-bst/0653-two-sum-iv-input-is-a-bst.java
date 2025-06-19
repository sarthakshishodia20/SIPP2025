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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set=new HashSet<>();
        return inorder(root,set,k);
    }
    public static boolean inorder(TreeNode root,HashSet<Integer> set,int k){
        if(root==null){
            return false;
        }
        if(inorder(root.left,set,k)){
            return true;
        }
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return inorder(root.right,set,k);
    }
}