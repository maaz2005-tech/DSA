class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int prev[]=new int[amount+1];
        for(int i=0;i<=n ;i++) prev[0]=1;
        int curr[]=prev;
        for(int i=1;i<=n;i++){
            int x=coins[i-1];
            for(int j=1;j<=amount;j++){
                curr[j]=prev[j];
                if(j>=x) curr[j]+=curr[j-x];
            }
            prev=curr;
        }
        return curr[amount];
    }
}