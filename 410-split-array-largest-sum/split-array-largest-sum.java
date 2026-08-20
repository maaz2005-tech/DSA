class Solution {
    boolean can(int nums[],long val,int k){
        long b=0;
        int currK=1;
        for(int x:nums){
            if(b+x<=val){
                b+=x;
            }
            else{
                currK++;
                b=x;
            }
            if(currK>k) return false;
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        long lo=0;
        long hi=0;
        for(int x:nums){
            hi+=x;
            lo=Math.max(lo,x);
        }
        long ans=-1;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if(can(nums,mid,k)){
                ans=mid;
                hi=mid-1;
            }
            else {
                lo=mid+1;
            }
        }
        return (int)ans;
    }
}