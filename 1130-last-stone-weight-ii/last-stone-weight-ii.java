class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int x:stones) sum+=x;
        // System.out.println(sum);
        // int target=(int)Math.ceil((double)sum/2);
        int target=sum/2;
        // target+=(sum%2==0)?0:1;
        // System.out.println(target);
        int dp[]=new int[target+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int stone:stones){
            for(int i=target;i>=stone;i--){
                if(dp[i-stone]!=-1) dp[i]=Math.max(dp[i],stone+dp[i-stone]);
            }
        }
        // System.out.println(dp[target]);
        // System.out.println(target);
        int best = target;
        while (dp[best] == -1) best--;

        return sum - 2 * best;
    }
}