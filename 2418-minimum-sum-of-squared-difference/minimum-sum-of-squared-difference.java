class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        int count[]=new int[100001];
        for(int i=0;i<n;i++){
            count[Math.abs(nums1[i]-nums2[i])]++;
        }
        int k=k1+k2;
        long ans=0;
        for(int i=100000;i>=1;i--){
            if(count[i]==0) continue;
            int currOp=Math.min(k,count[i]);
            count[i]-=currOp;
            ans+=(long)count[i]*i*i;
            count[i-1]+=currOp;
            k-=currOp;
        }
        return ans;
    }
}