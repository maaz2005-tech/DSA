class Solution {
    boolean isPalin(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            j--;i++;
        }
        return true;
    }
    public int minInsertions(String s) {
        int n=s.length();
        int dp[][]=new int[n+1][n+1];
        String r=new StringBuilder(s).reverse().toString();
        // System.out.println(r);
        // n- lcs of l and r 
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==r.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                // System.out.print(dp[i][j]+" ");
            }
            // System.out.println();
        }
        // System.out.println(dp[n][n]);
        return n-dp[n][n];
    }
}