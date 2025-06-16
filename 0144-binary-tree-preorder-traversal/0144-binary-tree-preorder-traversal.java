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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<TreeNode> s=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        s.push(root);
        while(!s.isEmpty()){
            TreeNode currNode=s.pop();
            ans.add(currNode.val);
            if(currNode.right!=null){
                s.push(currNode.right);
            }
            if(currNode.left!=null){
                s.push(currNode.left);
            }
        }
        return ans;
    }
}