class Solution {
    // recursion +memoization
    // int solve(int i,int count ,int buy,int prices[]){
    //     if(i==prices.length || count>=2) return 0;
    //     if(dp[i][count][buy]!=-1) return dp[i][count][buy];
    //     if(buy==1){
    //         return dp[i][count][buy]=Math.max(-prices[i]+solve(i+1,count,0,prices),solve(i+1,count,1,prices));
    //     }
    //     return dp[i][count][buy]=Math.max(+prices[i]+solve(i+1,count+1,1,prices),solve(i+1,count,0,prices));
    // }
    // int dp[][][];
    public int maxProfit(int[] prices) {
        // memoization
        // this.dp=new int[prices.length+1][2][2];
        // for(int i[][]:dp){
        //     for(int j[]:i) Arrays.fill(j,-1);
        // }
        // return solve(0,0,1,prices);

        // tabulation
        int n=prices.length;
        // this.dp=new int[n+1][3][2];

        // optimized space complexity
        int ahead[][]=new int[3][2];
        int curr[][]=new int[3][2];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int count=0;count<=1;count++){
                    if(buy==1){
                        curr[count][buy]=Math.max(-prices[i]+ahead[count][0],ahead[count][1]);
                    }
                    else{
                        curr[count][buy]=Math.max(+prices[i]+ahead[count+1][1],ahead[count][0]);
                    }
                }
            }
            ahead=curr;
        }
        return ahead[0][1];
    }
}