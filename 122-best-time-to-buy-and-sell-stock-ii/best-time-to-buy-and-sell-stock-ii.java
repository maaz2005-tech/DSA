class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int sell=0,bought=0;
        for(int i=n-1;i>=0;i--){
            int t1=0,t2=0;
            for(int buy=0;buy<2;buy++){
                if(buy==1){
                    t1=Math.max(-prices[i]+sell,bought);
                }
                else{
                    t2=Math.max(+prices[i]+bought,sell);
                }
            }
            sell=t2;
            bought=t1;
        }
        return bought;
    }
}