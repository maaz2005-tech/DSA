class Solution {
    public int climbStairs(int n, int[] costs) {
        int first =0 , second =0 , third=0;
        for(int i=1;i<=n;i++){
            int ans=Math.min(first+9,Math.min(second+4,third+1))+costs[i-1];
            first=second;
            second=third;
            third=ans;
        }
        return third;
    }
}