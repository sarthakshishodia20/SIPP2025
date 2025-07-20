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
class BSTIterator {
    private Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s=new Stack<>();
        pushAllLeft(s,root);
    }
    public void pushAllLeft(Stack<TreeNode> s,TreeNode root){
        while(root!=null){
            s.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode ans=s.pop();
        if(ans.right!=null){
            pushAllLeft(s,ans.right);
        }
        return ans.val;
    }
    
    public boolean hasNext() {
        return s.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */