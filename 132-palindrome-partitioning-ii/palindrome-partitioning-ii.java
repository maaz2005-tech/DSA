class Solution {
    boolean isPalin(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    int solve(String s,int l,int r,int dp[][]){
        if(l==r || isPalin(s,l,r)) {return 0;}
        if(dp[l][r]!=-1) return dp[l][r];
        int min=Integer.MAX_VALUE;
        for(int i=l;i<r;i++){
            if (isPalin(s, l, i)) {
                min = Math.min(min,
                        1 + solve(s, i + 1, r, dp));
            }        
        }
        return dp[l][r]=min;
    }
    public int minCut(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
        for(int i[]:dp) Arrays.fill(i,-1);
        return solve(s,0,n-1,dp);
    }
}