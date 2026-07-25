class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n==1) return s;
        return s+(long)(m-1)*(n/2)+1;
    }
}