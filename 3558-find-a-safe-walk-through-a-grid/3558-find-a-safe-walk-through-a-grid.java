class Solution {
    static class Pair {
        int row;
        int col;
        int health;
        public Pair(int r, int c, int health) {
            this.row = r;
            this.col = c;
            this.health = health;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        Queue<Pair> q = new LinkedList<>();
        int[] dx = {-1, 0, +1, 0};
        int[] dy = {0, +1, 0, -1};
        int[][] visited = new int[n][m];
        for (int[] row : visited) Arrays.fill(row, -1);
        q.add(new Pair(0, 0, health - grid.get(0).get(0)));
        visited[0][0] = health - grid.get(0).get(0);
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            int currHealth = curr.health;
            if (currRow == n - 1 && currCol == m - 1 && currHealth > 0) {
                return true;
            }
            for (int k = 0; k < 4; k++) {
                int nrow = currRow + dx[k];
                int ncol = currCol + dy[k];
                if (isValidMove(nrow, ncol, n, m)) {
                    int newHealth = currHealth - grid.get(nrow).get(ncol);
                    if (newHealth >= 0 && newHealth > visited[nrow][ncol]) {
                        visited[nrow][ncol] = newHealth;
                        q.add(new Pair(nrow, ncol, newHealth));
                    }
                }
            }
        }
        return false;
    }

    private boolean isValidMove(int r, int c, int n, int m) {
        return (r >= 0 && r < n && c >= 0 && c < m);
    }
}
