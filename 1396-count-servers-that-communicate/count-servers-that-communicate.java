class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int R[]=new int[n];
        int C[]=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                C[j]+=grid[i][j];
                R[i]+=grid[i][j];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 &&( R[i]>1 || C[j]>1)) ans++;
            }
        }
        return ans;
    }
}