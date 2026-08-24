class Solution {
    Integer dp[][][];
    public int solve(int piles[],int index,boolean turn,int m){
        int n=piles.length;
        if(index==n){
            return 0;
        }
        if(dp[turn?1:0][index][m]!=null) return dp[turn?1:0][index][m];
        int stones=0;
        int ans=(turn)?-1:Integer.MAX_VALUE;
        for(int x=1;x<=Math.min(2*m,n-index);x++){
            stones+=piles[x+index-1];
            if(turn){
                ans=Math.max(ans,stones+solve(piles,index+x,!turn,Math.max(m,x)));
            }
            else{
                ans=Math.min(ans,solve(piles,index+x,!turn,Math.max(m,x)));
            }
        }
        return dp[turn?1:0][index][m]=ans;
    }
    public int stoneGameII(int[] piles) {
        int m=1;
        this.dp=new Integer[2][101][101];
        return solve(piles,0,true,1);
    }
}