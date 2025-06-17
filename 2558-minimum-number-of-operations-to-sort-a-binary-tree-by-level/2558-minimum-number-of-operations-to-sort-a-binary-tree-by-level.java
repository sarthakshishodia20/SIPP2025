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
    public int minimumOperations(TreeNode root) {
        int totalSwaps=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int n=q.size();
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
            totalSwaps+=getCount(list);
        }
        return totalSwaps;
    }
    public static int getCount(List<Integer> list){
        int n=list.size();
        int count=0;
        
        int[] original=new int[list.size()];
        for(int i=0;i<list.size();i++){
            original[i]=list.get(i);
        }
        int[] sorted=new int[original.length];
        for(int i=0;i<n;i++){
            sorted[i]=original[i];
        }
        Arrays.sort(sorted);
        HashMap<Integer,Integer> indexMap=new HashMap<>();
        for(int i=0;i<n;i++){
            indexMap.put(sorted[i],i);
        }
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]|| original[i]==sorted[i]){
                continue;
            }
            int j=i;
            int cycleSize=0;
            while(!visited[j]){
                visited[j]=true;
                j=indexMap.get(original[j]);
                cycleSize++;
            }
            if(cycleSize>1){
                count+=(cycleSize-1);
            }
        }
        return count;

    }
}