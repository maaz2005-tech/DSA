class Solution {
    int solve(int pref[],int L,int M){
        int res=0;
        int n=pref.length;
        int maxLeftSubSum=0;
        for(int mEnd=L+M;mEnd<n;mEnd++){
            int lEnd=mEnd-M;
            int lStart=lEnd-L;
            int left=pref[lEnd]-pref[lStart];
            maxLeftSubSum=Math.max(maxLeftSubSum,left);
            int right=pref[mEnd]-pref[mEnd-M];
            res=Math.max(maxLeftSubSum+right,res);
        }
        return res;
    }
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n=nums.length;
        int pref[]=new int[n+1];
        for(int i=1;i<=n;i++){
            pref[i]=pref[i-1]+nums[i-1];
        }
        return Math.max(solve(pref,firstLen,secondLen),solve(pref,secondLen,firstLen));
    }
}