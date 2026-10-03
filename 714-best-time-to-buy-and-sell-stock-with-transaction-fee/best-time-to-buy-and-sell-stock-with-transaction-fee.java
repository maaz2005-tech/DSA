class Solution {
    int solve(int prices[],int i,int buy,int fee){
        if(i==prices.length) return 0;
        if(buy==1){
            return Math.max(-prices[i]+solve(prices,i+1,0,fee),solve(prices,i+1,1,fee));
        }
        return Math.max(+prices[i]-fee+solve(prices,i+1,1,fee),solve(prices,i+1,0,fee));
    }
    public int maxProfit(int[] prices, int fee) {
        // recursion
        // can use dp[n+1][2] where dp[n] all zeros
        // return solve(prices,0,1,fee);
        int n=prices.length;
        int ahead[]=new int[2];
        int curr[]=new int[2];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==1){
                    curr[1]=Math.max(-prices[i]+ahead[0],ahead[1]);
                }
                else{
                    curr[0]=Math.max(+prices[i]-fee+ahead[1],ahead[0]);
                }
            }
            ahead=curr;
        }
        return curr[1];
    }
}