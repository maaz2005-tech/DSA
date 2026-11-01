class Solution {
    public int minMoves(int[] nums) {
        int num=nums[0];
        int sum=0;
        for(int x:nums){
            num=Math.min(num,x);
            sum+=x;
        }
        return sum-nums.length*num;
    }
}