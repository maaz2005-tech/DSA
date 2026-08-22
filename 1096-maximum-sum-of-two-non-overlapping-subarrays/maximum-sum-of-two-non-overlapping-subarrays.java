class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int l, int m) {
        int n=nums.length;
        int pref[]=new int[n+1];
        for(int i=1;i<=n;i++){
            pref[i]=pref[i-1]+nums[i-1];
        }
        int max=0;
        for(int i=0;i<=(n-l-m+1);i++){
            int currMax=0;
            int first=pref[i+l]-pref[i];
            for(int j=i+l+m;j<=n;j++){
                int second=pref[j]-pref[j-m];
                currMax=Math.max(first+second,currMax);
            }
            max=Math.max(max,currMax);
        }
        for(int i=0;i<=(n-l-m+1);i++){
            int currMax=0;
            int first=pref[i+m]-pref[i];
            for(int j=i+l+m;j<=n;j++){
                int second=pref[j]-pref[j-l];
                currMax=Math.max(first+second,currMax);
            }
            max=Math.max(max,currMax);
        }
        return max;
    }
}