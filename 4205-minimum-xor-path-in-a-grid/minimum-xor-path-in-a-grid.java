class Solution {
    public int minCost(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        Set<Integer> dp[][]=new HashSet[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=new HashSet<>();
            }
        }
        dp[0][0].add(grid[0][0]);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>0){
                    for(int val:dp[i-1][j]) dp[i][j].add(grid[i][j]^val);
                }
                if(j>0){
                    for(int val:dp[i][j-1]) dp[i][j].add(grid[i][j]^val);
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int val:dp[n-1][m-1]) ans=Math.min(val,ans);
        return ans;
    }
}