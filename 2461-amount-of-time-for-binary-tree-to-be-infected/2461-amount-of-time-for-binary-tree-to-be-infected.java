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
    public static void assignParents(TreeNode root,HashMap<TreeNode,TreeNode> map){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode currNode=q.poll();
            if(currNode.left!=null){
                map.put(currNode.left,currNode);
                q.add(currNode.left);
            }
            if(currNode.right!=null){
                map.put(currNode.right,currNode);
                q.add(currNode.right);
            }
        }
        return;
    }
    public static TreeNode targetNode(TreeNode root,int target){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        TreeNode ans=null;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode currNode=q.poll();
                if(currNode.val==target){
                    ans=currNode;
                    return ans;
                }
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
        return ans;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        assignParents(root,map);
        TreeNode target=targetNode(root,start);
        return timeTaken(root,target,map);
    }
    public static int timeTaken(TreeNode root,TreeNode target,HashMap<TreeNode,TreeNode> map){
        int time=0;
        HashSet<TreeNode> visited=new HashSet<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        visited.add(target);
        while(!q.isEmpty()){
            boolean burned=false;
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode currNode=q.poll();
                if(currNode.left!=null && !visited.contains(currNode.left)){
                    q.add(currNode.left);
                    visited.add(currNode.left);
                    burned=true;
                }
                if(currNode.right!=null && !visited.contains(currNode.right)){
                    q.add(currNode.right);
                    visited.add(currNode.right);
                    burned=true;
                }
                if(map.containsKey(currNode) &&!visited.contains(map.get(currNode))){
                    visited.add(map.get(currNode));
                    q.add(map.get(currNode));
                    burned=true;
                }
            }
            if(burned){
                time++;
            }
        }
        return time;
    }
}