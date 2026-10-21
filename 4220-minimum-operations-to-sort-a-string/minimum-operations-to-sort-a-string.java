class Solution {
    boolean isSorted(String s,int n){
        for(int i=1;i<n;i++){
            if(s.charAt(i)<s.charAt(i-1)) return false;
        }
        return true;
    }
    public int minOperations(String s) {
        int n=s.length();
        if(isSorted(s,n)) return 0;
        int mn=0,mx=0;
        for(int i=0;i<n;i++){
            if(s.charAt(mn)>s.charAt(i)) mn=i;
            if(s.charAt(mx)<=s.charAt(i)) mx=i;
        }
        if(mn==0 || mx==n-1) return 1;
        if(mn==n-1 && mx==0 ){
            if(n==2) return -1;
            return 3;
        }
        return 2;
    }
}