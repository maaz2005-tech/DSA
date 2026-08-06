class Solution {
    boolean solve(int n,int t){
        long prod=1;
        int x=n;
        while(x>0){
            prod*=(x%10);
            x/=10;
        }
        return (prod%(long)t)==0;
    }
    public int smallestNumber(int n, int t) {
        while(!solve(n,t)){
            n++;
        }
        return n;
    }
}