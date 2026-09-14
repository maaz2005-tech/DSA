class Solution {
    int start=0,end=0;
    void solve(String s,int n,int i){
        int l=i,r=i;
        while(r<n-1 && s.charAt(r)==s.charAt(r+1)) r++;
        while(l>0 && r<n-1 && s.charAt(l-1)==s.charAt(r+1)){
            l--;r++;
        }
        if(end-start<r-l){
            end=r;
            start=l;
        }
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        for(int i=0;i<n;i++){
            solve(s,n,i);
        }
        return s.substring(start,end+1);
    }
}