class Solution {
    public int minMoves(int[] nums) {
        int num=nums[0];
        for(int x:nums){
            num=Math.min(num,x);
        }
        int ans=0;
        for(int x:nums){
            ans+=Math.abs(x-num);
        }
        return ans;
    }
}