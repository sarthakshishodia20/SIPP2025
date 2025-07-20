class Solution {
    static class BSTIterator {
        private Stack<TreeNode> s = new Stack<>();
        public BSTIterator(TreeNode root) {
            pushAllLeft(root);
        }
        private void pushAllLeft(TreeNode node) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
        }
        public int next() {
            TreeNode top = s.pop();
            if (top.right != null) {
                pushAllLeft(top.right);
            }
            return top.val;
        }
        public boolean hasNext() {
            return !s.isEmpty();
        }
    }
    static class BSTReverseIterator {
        private Stack<TreeNode> s = new Stack<>();
        public BSTReverseIterator(TreeNode root) {
            pushAllRight(root);
        }
        private void pushAllRight(TreeNode node) {
            while (node != null) {
                s.push(node);
                node = node.right;
            }
        }
        public int prev() {
            TreeNode top = s.pop();
            if (top.left != null) {
                pushAllRight(top.left);
            }
            return top.val;
        }
        public boolean hasPrev() {
            return !s.isEmpty();
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator l = new BSTIterator(root);
        BSTReverseIterator r = new BSTReverseIterator(root);
        int i = l.next(); 
        int j = r.prev(); 
        while (i < j) {
            int sum = i + j;
            if (sum == k) {
                return true;
            } else if (sum < k) {
                if (l.hasNext()) {
                    i = l.next();
                } else {
                    return false;
                }
            } else {
                if (r.hasPrev()) {
                    j = r.prev();
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
