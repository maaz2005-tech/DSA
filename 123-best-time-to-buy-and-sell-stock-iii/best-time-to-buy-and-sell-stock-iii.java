class Solution {
    int solve(int i,int count ,int buy,int prices[]){
        if(i==prices.length || count>=2) return 0;
        if(dp[i][count][buy]!=-1) return dp[i][count][buy];
        if(buy==1){
            return dp[i][count][buy]=Math.max(-prices[i]+solve(i+1,count,0,prices),solve(i+1,count,1,prices));
        }
        return dp[i][count][buy]=Math.max(+prices[i]+solve(i+1,count+1,1,prices),solve(i+1,count,0,prices));
    }
    int dp[][][];
    public int maxProfit(int[] prices) {
        this.dp=new int[prices.length+1][2][2];
        for(int i[][]:dp){
            for(int j[]:i) Arrays.fill(j,-1);
        }
        return solve(0,0,1,prices);
    }
}