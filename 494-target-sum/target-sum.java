class Solution {
    int solve(int nums[],int curr,int i){
        if(i==nums.length){
            if(target==curr) return 1;
            return 0;
        }
        return solve(nums,curr-nums[i],i+1)+solve(nums,curr+nums[i],i+1);
    }
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        this.target=target;
        return solve(nums,0,0);
    }
}