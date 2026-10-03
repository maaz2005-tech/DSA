class Solution {
    public int maxProfit(int[] prices) {
        // maaz2005-tech
        int n=prices.length;
        // int dp[][][]=new int[n+1][2][2];
        int curr[][]=new int[2][2];
        int ahead[][]=new int[2][2];
        // 1-> can buy 0-> can not buy
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int can=0;can<=1;can++){
                    if(buy==1){
                        if(can==1) curr[1][can]=Math.max(-prices[i]+ahead[0][0],ahead[1][1]);
                        else curr[1][0]=ahead[1][1];
                    }
                    else{
                        curr[0][can]=Math.max(+prices[i]+ahead[1][0],ahead[0][can]);
                    }
                }
            }
            ahead=curr;
        }
        return ahead[1][1];
    }
}