class Solution {
    public int minOperations(int[] nums) {
        int bp=0;
        int mi=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[mi]>nums[i]) mi=i;
            if(nums[i-1]>nums[i]) bp++;
        }
        if(nums[n-1]>nums[0]) bp++;
        if(bp==0) return 0;
        if(bp!=1 && bp!=(n-1)) return -1;
        if(bp==1){
            int ri=n-mi-1;
            return Math.min(mi,3+ri);
        }
        if(bp==n-1){
            int ri=n-mi-1;
            return Math.min(mi+2,ri+1);
        }
        return 0;
    }
}