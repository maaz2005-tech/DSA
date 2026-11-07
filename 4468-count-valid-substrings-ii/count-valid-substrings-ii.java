class Solution {
    public long countValidSubstrings(String s) {
        int la=-1;
        int lab=-1;
        int maxFirst=-1;
        int n=s.length();
        long ans=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'){
                la=i;
            }
            else if(ch=='b'){
                lab=la;
            }
            else{
                maxFirst=Math.max(maxFirst,lab);
            }
            ans+=i-maxFirst;
        }
        return ans;
    }
}