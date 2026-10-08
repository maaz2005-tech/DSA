class Solution {
    public int numDistinct(String s, String t) {
        // dp[][]=dp[i-1][j-1]+dp[i-1][j]
        // dp[][]=dp[i-1][j]
        int n=s.length();
        int m=t.length();
        int dp[]=new int[m+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=m;j>0;j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[j]+=dp[j-1];
                }
            }
        }
        return dp[m]; 
    }
}