class Solution {
    public int minChanges(String s) {
        int n=s.length();
        int ans=0;
        int size=0;
        for(int i=0;i<n;i++){
            if(size==0){
                size++;
                continue;
            }
            if(s.charAt(i)!=s.charAt(i-1)){
                if(size%2!=0){
                    ans++;
                    size=0;
                }
                else{
                    size=1;
                }
            }
            else{
                size++;
            }
        }
        return ans;
    }
}