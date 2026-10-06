class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][2];
        for(int i[]:dp) Arrays.fill(i,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i] && dp[i][1]<dp[j][1]+1){
                    dp[i][1]=dp[j][1]+1;
                    dp[i][0]=dp[j][0];
                }
                else if(nums[j]<nums[i] && dp[i][1]==dp[j][1]+1){
                    dp[i][0]+=dp[j][0];
                }
            }
            if(max<dp[i][1]) max=Math.max(max,dp[i][1]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i][1]==max) ans+=dp[i][0];
        }
        return ans;
    }
}