/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // Recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val <p.val && root.val <q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }


    // Iterative
    // public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
    //     if(root==null){
    //         return null;
    //     }
    //     while(root!=null){
    //         if(root.val <p.val && root.val <q.val){
    //             root=root.right;
    //         }
    //         else if(root.val>p.val && root.val>q.val){
    //             root=root.left;
    //         }
    //         else{
    //             return root;
    //         }
    //     }
    //     return null;
    // }
}