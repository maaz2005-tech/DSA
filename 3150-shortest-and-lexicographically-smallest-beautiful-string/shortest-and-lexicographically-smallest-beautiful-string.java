class Solution {

    // maaz2005-tech (GitHub)

    boolean check(String s,int sl,int l,int n){
        while(l<n && sl<n){
            if(s.charAt(l)==s.charAt(sl)){
                l++;sl++;
            }
            else{
                if((s.charAt(l)-'0')<(s.charAt(sl)-'0')){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
            return false;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int l=0;
        int sl=-1,sr=n;
        int one=0;
        for(int r=0;r<n;r++){
            if(s.charAt(r)=='1') one++;
            while(l<=r && (s.charAt(l)=='0'||one>k)){
                if(s.charAt(l++)=='1'){
                    one--;
                } 
            }
            if(one==k){
                if((sr-sl+1)>(r-l+1) ||((sr-sl+1)==(r-l+1)&&check(s,sl,l,n))){
                    sl=l;sr=r;
                }
                
            }
        }
        return (sl==-1)?"":s.substring(sl,sr+1);
    }
}