class Solution {
    int solve(int nums[],int l,int r,int dp[][]){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int ans=0;
        for(int i=l;i<=r;i++){
            int curr=(l==0?1:nums[l-1])*nums[i]*((r==nums.length-1)?1:nums[r+1])
                +solve(nums,l,i-1,dp)+solve(nums,i+1,r,dp);
            ans=Math.max(ans,curr);
        }
        return dp[l][r]=ans;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        return solve(nums,0,n-1,dp);
    }
}