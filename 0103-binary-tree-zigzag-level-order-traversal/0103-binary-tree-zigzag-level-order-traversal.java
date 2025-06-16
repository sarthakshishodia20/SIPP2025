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
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> q=new LinkedList<>();
        boolean reverse=false;
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode currNode=q.poll();
                list.add(currNode.val);
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            if(reverse==true){
                Collections.reverse(list);
            }
            reverse=!reverse;
            result.add(list);
        }
        return result;
    }
}