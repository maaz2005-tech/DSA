class Solution {
    public int minDistance(String word1, String word2) {
        // maaz2005-tech
        int n=word1.length(),m=word2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i]=i;
        }
        for (int i=1;i<=n ;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                char c1=word1.charAt(i-1);
                char c2=word2.charAt(j-1);
                if(c1==c2){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1; // comparing -> repalce then delete then insert
                }
            }
        }
        return dp[n][m];
    }
}