class Solution {
    int solve(int[] piles,int l,int r,int a,int b,boolean turn,int dp[][]){
        if(l>r) return (a>b)?1:0;
        if(dp[l][r]!=-1) return dp[l][r];
        if(turn){
            return dp[l][r]=(solve(piles,l,r-1,a+piles[r],b,false,dp)==1||solve(piles,l+1,r,a+piles[l],b,false,dp)==1)?1:0;
        }
        return dp[l][r]=(solve(piles,l,r-1,a,b+piles[r],true,dp)==1||solve(piles,l+1,r,a,b+piles[l],true,dp)==1)?1:0;
    }

    public boolean stoneGame(int[] piles) {
        int dp[][]=new int[piles.length][piles.length];
        for(int i[]:dp) Arrays.fill(i,-1);
        return solve(piles,0,piles.length-1,0,0,true,dp)==1;
    }
}