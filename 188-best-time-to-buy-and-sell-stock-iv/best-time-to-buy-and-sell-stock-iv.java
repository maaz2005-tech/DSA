class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int ahead[][]=new int[k+1][2];
        int curr[][]=new int[k+1][2];
        for(int i=n-1;i>=0;i--){
            for(int count=0;count<k;count++){
                for(int buy=0;buy<=1;buy++){
                    if(buy==1){
                        curr[count][buy]=Math.max(-prices[i]+ahead[count][0],ahead[count][1]);
                    }
                    else{
                        curr[count][buy]=Math.max(prices[i]+ahead[count+1][1],ahead[count][0]);
                    }
                }
            }
            ahead=curr;
        }
        return curr[0][1];
    }
}