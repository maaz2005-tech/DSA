class Solution {
    int solve(int grid[][],int i,int j,int k,int dp[][][]){
        if(i==grid.length) return 0;
        if(j<0 || j>=grid[0].length || k<0 || k>=grid[0].length){
            return Integer.MIN_VALUE;
        }
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        int cherry=grid[i][j];
        if(j!=k) cherry+=grid[i][k];
        int ans=Integer.MIN_VALUE;
        
        for(int val1=-1;val1<=1;val1++){
            for(int val2=-1;val2<=1;val2++){
                ans=Math.max(ans,solve(grid,i+1,j+val1,k+val2,dp));
            }
        }
        return dp[i][j][k]=ans+cherry;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][][]=new int[n+1][m+1][m+1];
        for(int i[][]:dp){
            for(int j[]:i) Arrays.fill(j,-1);
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){

        //     }
        //     for(int )
        // }
        return solve(grid,0,0,m-1,dp);
    }
}