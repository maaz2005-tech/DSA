class Solution {
    public long maxAlternatingSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length,i=0,j=n-1,op=(n+1)/2;
        long ans=0L;
        while(i<=j){
            if(op==0){
                ans-=(long)nums[i]*nums[i++];
            }
            else{
                if(Math.abs(nums[i])>Math.abs(nums[j])){
                    ans+=(long)nums[i]*nums[i++];
                }
                else{
                    ans+=(long)nums[j]*nums[j--];
                }
                op--;
            }
        }
        return ans;
    }
}