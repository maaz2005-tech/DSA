class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0,n=nums.length;
        for(int x:nums) sum+=x;
        if(sum%2!=0) return false;
        boolean dp[][]=new boolean[n+1][sum/2+1];
        for(int i=0;i<=n;i++) dp[i][0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=(sum/2);j++){
                if(j>=nums[i-1]){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum/2];
    }
}