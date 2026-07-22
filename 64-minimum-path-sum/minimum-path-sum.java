class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int dp[][]=new int[n+1][m+1];
        Arrays.fill(dp[0],100000000);
        for(int i=0;i<=n;i++){
            dp[i][0]=100000000;
        }
        dp[0][1]=0;
        dp[1][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[n][m];
    }
}