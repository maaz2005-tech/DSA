class Solution {
    long dfs(int grid[][],int r,int c,boolean vis[][]){
        vis[r][c]=true;
        int dr[]={0,1,0,-1};
        int dc[]={1,0,-1,0};
        long ans=(long)grid[r][c];
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[r].length && grid[nr][nc]!=0 && !vis[nr][nc]){
                ans+=dfs(grid,nr,nc,vis);
            }
        }
        return ans;
    }
    public int countIslands(int[][] grid, int k) {
        int ans=0;
        int n=grid.length,m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 && !vis[i][j] && dfs(grid,i,j,vis)%k==0L){
                    ans++;
                }
            }
        }
        return ans;
    }
}