class Solution {
    public int minOperations(String s) {
        int n=s.length();
        String doubled=s+s;
        int ans=Integer.MAX_VALUE;
        for(int k=0;k<n;k++){
            int cost=k;
            int l=k;
            int r=k+n-1;
            while(l<r){
                int diff=Math.abs(doubled.charAt(l)-doubled.charAt(r));
                cost+=Math.min(26-diff,diff);
                l++;r--;
            }
            ans=Math.min(ans,cost);
        }
        return ans;
    }
}