class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int sum=0;
        for(int num:nums) sum+=num;
        int sumToBeChecked=sum-x;
        if(sumToBeChecked<0) return -1;
        if(sumToBeChecked==0) return n;
        int l=0;

        sum=0;
        int ans=0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(l<r && sum>sumToBeChecked){
                sum-=nums[l++];
            }
            if(sum==sumToBeChecked){
                ans=Math.max(r-l+1,ans);
            }
        }
        return ans==0?-1:n-ans;
    }
}