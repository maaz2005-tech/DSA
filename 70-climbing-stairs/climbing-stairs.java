class Solution {
    public int climbStairs(int n) {
        int first=1,second=1;
        if(n==0 || n==1) return 1;
        for(int i=2;i<=n;i++){
            int ans=first+second;
            first=second;
            second=ans;
        }
        return second;
    }
}