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
    static class Pair{
        TreeNode node;
        int index;
        public Pair(TreeNode n,int i){
            node=n;
            index=i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int maxWidth=0;
        while(!q.isEmpty()){
            int firstIndex=q.peekFirst().index;
            int lastIndex=q.peekLast().index;
            maxWidth=Math.max(lastIndex-firstIndex+1,maxWidth);
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                TreeNode currNode=curr.node;
                int I=curr.index;
                if(currNode.left!=null){
                    q.addLast(new Pair(currNode.left,2*I+1));
                }
                if(currNode.right!=null){
                    q.addLast(new Pair(currNode.right,2*I+2));
                }
            }
        }
        return maxWidth;
    }
}