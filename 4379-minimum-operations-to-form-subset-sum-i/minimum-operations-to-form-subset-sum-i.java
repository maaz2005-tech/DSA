class Solution {
    int solve(int nums[],int i,int sum,int[][] dp){
        if(sum==0) return 0;
        if(i==nums.length || sum<0) return Integer.MAX_VALUE;
        if(dp[i][sum]!=-1) return dp[i][sum];
        int ans=Math.min(solve(nums,i+1,sum,dp),solve(nums,i+1,sum-nums[i],dp));
        int op=0;
        int x=nums[i];
        while(x<sum){
            op++;
            x*=2;
            int val=solve(nums,i+1,sum-x,dp);
            if(val!=Integer.MAX_VALUE){
                ans=Math.min(val+op,ans);
            }
        }
        op=0;
        x=nums[i];
        while(x>0){
            op++;
            x/=2;
            int val=solve(nums,i+1,sum-x,dp);
            if(val!=Integer.MAX_VALUE){
                ans=Math.min(val+op,ans);
            }
        }
        return dp[i][sum]=ans;
    }
    public int minOperations(int[] nums, int sum) {
        int dp[][]=new int[nums.length+1][sum+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        int ans=solve(nums,0,sum,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}