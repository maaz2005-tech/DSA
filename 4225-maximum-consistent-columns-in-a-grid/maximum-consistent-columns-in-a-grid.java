class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[]=new int[m];
        Arrays.fill(dp,1);
        for(int j=1;j<m;j++){
            for(int i=0;i<j;i++){
                boolean isCom=true;
                for(int k=0;k<n;k++){
                    if(Math.abs(grid[k][j]-grid[k][i])>limit){
                        isCom=false;
                    }
                }
                if(isCom) dp[j]=Math.max(dp[j],dp[i]+1);
            }
        }
        int max=1;
        for(int x:dp) max=Math.max(max,x);
        return max;
    }
}