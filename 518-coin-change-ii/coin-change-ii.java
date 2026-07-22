class Solution {
    int solve(int coins[],int i,int amount){
        if(amount==0) return 1;
        if(i<0) return 0;
        if(dp[i][amount]!=null) return dp[i][amount];
        int ans=0;
        ans+=solve(coins,i-1,amount);
        if(amount>=coins[i]) ans+=solve(coins,i,amount-coins[i]);
        return dp[i][amount]=ans;
    }
    Integer dp[][];
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        this.dp=new Integer[coins.length][amount+1];
        return solve(coins,coins.length-1,amount);
    }
}