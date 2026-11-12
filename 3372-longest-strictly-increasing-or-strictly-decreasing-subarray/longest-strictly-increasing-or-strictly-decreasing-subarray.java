class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=1;
        int n=nums.length;
        int l=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]) l++;
            else l=1;
            ans=Math.max(ans,l);
        }
        l=1;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]) l++;
            else l=1;
            ans=Math.max(ans,l);
        }
        return ans;
    }
}