class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=1;
        int n=nums.length;
        int cI=1;
        int cD=1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                cI++;
                cD=1;
            }
            else if(nums[i]<nums[i-1]){
                cD++;
                cI=1;
            }
            else{
                cI=1;cD=1;
            }
            ans=Math.max(ans,Math.max(cI,cD));
        }
        return ans;
    }
}