class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int dp[][]=new int[n][m];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=Math.min(dp[i-1][j],Math.min(j==0?Integer.MAX_VALUE:dp[i-1][j-1],j==m-1?Integer.MAX_VALUE:dp[i-1][j+1]))+matrix[i][j];
            }
        }
        for(int i=0;i<m;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }
}