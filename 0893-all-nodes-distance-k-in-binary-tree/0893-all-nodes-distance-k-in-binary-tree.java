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
    public static void assignParents(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode currNode = q.poll();
            if (currNode.left != null) {
                map.put(currNode.left, currNode);
                q.add(currNode.left);
            }
            if (currNode.right != null) {
                map.put(currNode.right, currNode);
                q.add(currNode.right);
            }
        }
        return;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        assignParents(root, map);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        int currentKay = 0;
        while (!q.isEmpty()) {
            if (currentKay == k)
                break;
            int size = q.size(); 
            for (int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();
                if (currNode.left != null && !visited.contains(currNode.left)) {
                    q.add(currNode.left);
                    visited.add(currNode.left);
                }
                if (currNode.right != null && !visited.contains(currNode.right)) {
                    q.add(currNode.right);
                    visited.add(currNode.right);
                }
                if (map.containsKey(currNode) && !visited.contains(map.get(currNode))) {
                    q.add(map.get(currNode));
                    visited.add(map.get(currNode));
                }
            }
            currentKay++;
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
}