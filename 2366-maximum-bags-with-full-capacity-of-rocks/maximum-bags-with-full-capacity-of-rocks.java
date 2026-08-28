class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        int del[]=new int[n];
        for(int i=0;i<n;i++){
            del[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(del);
        int ans=0;
        for(int i=0;i<n;i++){
            if(additionalRocks<del[i]) break;
            additionalRocks-=del[i];
            ans++;
        }
        return ans;
    }
}