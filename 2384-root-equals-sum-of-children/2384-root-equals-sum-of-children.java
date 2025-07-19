class Solution {
    public boolean checkTree(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int leftValue = (root.left != null) ? root.left.val : 0;
        int rightValue = (root.right != null) ? root.right.val : 0;
        if(root.val == leftValue + rightValue && 
           checkTree(root.left) && 
           checkTree(root.right)) {
            return true;
        }
        return false;
    }
}
