class Solution {
    public long minCost(int[] nums) {
        int l=0;
        long ans=Long.MAX_VALUE;
        int n=nums.length;
        for(int r=1;r<n;r++){
            if(nums[l]!=nums[r]) l=r;
            if(l==n-1) break;
            ans=Math.min(ans,1L*l*nums[l] +1L*(n-1-r)*nums[r]);
        }
        return ans;
    }
}