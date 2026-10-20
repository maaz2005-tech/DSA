class Solution {
    boolean check(int nums[],int len){
        int n=nums.length;
        int min=0;
        for(int i=0;i<n;i+=len){
            if(nums[i]<min) return false;
            boolean point=false;
            int max=nums[i];
            for(int j=i+1;j<(i+len);j++){
                if(nums[j]<min) return false;
                max=Math.max(max,nums[j]);
                if(nums[j]<nums[j-1]){
                    if(point) return false;
                    point=true;
                }
            }
            if(point && nums[i]<nums[i+len-1]) return false;
            min=max;
        }
        return true;
    }
    public int sortableIntegers(int[] nums) {
        int ans=0;
        int n=nums.length;
        // find no of break points in nums
        // if bp is >1 return false and 
        // if bp is 1 check nums[0]>nums[n-1] or not
        for(int i=1;i<=n;i++){
            if(n%i!=0) continue;
            if(check(nums,i)) ans+=i;
        }
        return ans;
    }
}