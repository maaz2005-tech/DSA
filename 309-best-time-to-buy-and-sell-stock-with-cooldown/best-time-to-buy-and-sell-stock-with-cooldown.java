class Solution {
    public int maxProfit(int[] prices) {
        // maaz2005-tech
        int n=prices.length;
        int dp[][][]=new int[n+1][2][2];
        // 1-> can buy 0-> can not buy
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int can=0;can<=1;can++){
                    if(buy==1){
                        if(can==1) dp[i][1][can]=Math.max(-prices[i]+dp[i+1][0][0],dp[i+1][1][1]);
                        else dp[i][1][0]=dp[i+1][1][1];
                    }
                    else{
                        dp[i][0][can]=Math.max(+prices[i]+dp[i+1][1][0],dp[i+1][0][can]);
                    }
                }
            }
        }
        return dp[0][1][1];
    }
}