class Solution {
    private long C(int n,int r,long[] fac){
        if(r<0 || r>n) return 0;
        long denominator=fac[r]*fac[n-r]%MOD;
        return (fac[n]*power(denominator,MOD-2))%MOD;
    }
    static final int MOD=1_000_000_007;
    public int countValidSequences(int n, int k) {
        // maaz2005-tech

        // total-oddSequence
        // total sequence -> (n-1)C(k-1)
        // odd sequence-> ((n-k)/2 +k-1)C(k-1) -> ((n+k-2)/2)C(k-1)
        long fac[]=new long[n+1];
        fac[0]=1;
        for(int i=1;i<=n;i++){
            fac[i]=(fac[i-1]*i)%MOD;
        }
        long total=C(n-1,k-1,fac);
        long odd=0;
        if((n-k)%2==0){
            odd=C((n+k-2)/2,k-1,fac);
        }
        return (int)(total-odd+MOD)%MOD;
    }
    private long power(long base,long exp){
        long result=1;
        while(exp>0){
            if((exp&1)==1){
                result=(result*base)%MOD;
            }
            base=(base*base)%MOD;
            exp>>=1;
        }
        return result;
    }
}