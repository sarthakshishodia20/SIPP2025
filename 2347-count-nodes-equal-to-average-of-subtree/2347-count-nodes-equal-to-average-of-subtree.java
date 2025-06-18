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
    public int averageOfSubtree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int count=0;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode currNode=q.poll();
                if(KyaMainBanSaktaHun(currNode)){
                    count++;
                }
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
        return count;
    }
    public static boolean KyaMainBanSaktaHun(TreeNode root){
        if(root==null){
            return false;
        }
        int countnodes=countNodes(root);
        int sumofnodes=sumOfNodes(root);
        int check=sumofnodes/countnodes;
        if(check==root.val){
            return true;
        }
        else{
            return false;
        }
    }
    public static int countNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftCount=countNodes(root.left);
        int rightCount=countNodes(root.right);
        return leftCount+rightCount+1;
    }
    public static int sumOfNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSum=sumOfNodes(root.left);
        int rightSum=sumOfNodes(root.right);
        return leftSum+rightSum+root.val;
    }

}