class Solution {
    public int minDays(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int score=1;score<=n;score++){
            int sum=0;
            for(int k=1;k<=score;k++){
                sum+=k;
                if(sum>score) break;
                int remaining=score-sum;
                if(remaining==0) dp[score]=Math.min(dp[score],k);
                else if(dp[remaining]!=Integer.MAX_VALUE){
                    dp[score]=Math.min(dp[score],dp[remaining]+1+k);
                }
            }
        }
        return dp[n];
    }
}