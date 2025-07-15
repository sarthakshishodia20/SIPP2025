class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[i++] = node;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (i == V) return ans;       
        else return new int[0];       
    }
}
