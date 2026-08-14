class Solution {
    public int maximumLengthSubstring(String s) {
        int l=0;
        int max=0;
        int count[]=new int[26];
        int n=s.length();
        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            count[ch-'a']++;
            while(l<=r && count[ch-'a']>2){
                count[s.charAt(l++)-'a']--;
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }
}