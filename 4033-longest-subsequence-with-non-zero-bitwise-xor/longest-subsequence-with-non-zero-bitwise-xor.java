class Solution {
    public int longestSubsequence(int[] nums) {
        // HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int lzi=-1;
        int curr=0;
        for(int i=0;i<n;i++){
            curr^=nums[i];
            if(nums[i]>0) lzi=i;
        }
        if(curr>0) return n;
        if(lzi==-1) return 0;
        return n-1;
    }
}