class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[n+1];
        for(int i=1;i<=n;i++){
            int ans=Integer.MAX_VALUE;
            for(int j=i-1;j>=0 && (i-j)<=3;j--){
                ans=Math.min(ans,(i-j)*(i-j)+dp[j]);
            }
            dp[i]=ans+costs[i-1];
        }
        return dp[n];
    }
}