class Solution {
    public int countIslands(int[][] grid, int k) {
        int count=0;
        int[] dx={-1,0,+1,0};
        int[] dy={0,+1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0 && visited[i][j]==0){
                    int sum=dfs(i,j,grid,visited,dx,dy);
                    if((sum%k)==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static int dfs(int row,int col,int[][] grid,int[][] visited,int[] dx,int[] dy){
        int sum=grid[row][col];
        visited[row][col]=1;
        for(int k=0;k<4;k++){
            int nrow=row+dx[k];
            int ncol=col+dy[k];
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[row][col]>0 && visited[nrow][ncol]==0){
                sum+=dfs(nrow,ncol,grid,visited,dx,dy);
            }
        }
        return sum;
    }
}