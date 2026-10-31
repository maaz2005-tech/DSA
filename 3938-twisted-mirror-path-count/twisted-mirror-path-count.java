class Solution {
    final int MOD=1_000_000_007;
    int n,m;
    int solve(int grid[][],int r,int c,int prev){
        if(r>=n || c>=m) return 0;
        if(r==n-1 && c==m-1) return 1;
        if(dp[r][c][prev]!=-1) return dp[r][c][prev];
        if(grid[r][c]==1){
            int ans=0;
            if(prev==0) ans=solve(grid,r+1,c,1);
            else ans=solve(grid,r,c+1,0);
            return dp[r][c][prev]=ans;
        }
        int ans=0;
        ans+=solve(grid,r+1,c,1);
        ans=ans%MOD;
        ans+=solve(grid,r,c+1,0);
        return dp[r][c][prev]=ans%MOD;
    }
    int[][][] dp;
    public int uniquePaths(int[][] grid) {
        this.n=grid.length;
        this.m=grid[0].length;
        this.dp=new int[n][m][2];
        for(int i[][]:dp) for(int j[]:i) Arrays.fill(j,-1);
        return solve(grid,0,0,0);
    }
    // {

        // int n=grid.length,m=grid[0].length;
        // int dp[][]=new int[n][m];
        // dp[0][0]=1;
        // int i=0;
        // while(i<m && grid[i][0]==0) dp[i++][0]=1;
        // i=0;
        // while(i<n && grid[0][i]==0) dp[0][i++]=1;
        // for(i=1;i<n;i++){
        //     for(int j=1;j<m;j++){
        //         int ans=0;
        //         if(grid[i-1][j]==1){
        //             ans+=dp[i-1][j-1];
        //         }
        //         else{
        //             ans+=dp[i-1][j];
        //         }
        //         if(grid[i][j-1]==1) ans+=dp[i-1][j-1];
        //         else ans+=dp[i][j-1];
        //         dp[i][j]=ans;
        //     }
        // }
        // return dp[n-1][m-1];
    // }
}