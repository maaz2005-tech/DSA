class Solution {
    int result(int nums[],int d){
        int sum=0;
        for(int x:nums){
            sum+=(Math.ceil((double)x/d));
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max=0;
        for(int x:nums) max=Math.max(max,x);
        int l=1,r=max;
        int ans=max;
        while(l<=r){
            int mid=l+(r-l)/2;
            int res=result(nums,mid);
            if(res<=threshold){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}