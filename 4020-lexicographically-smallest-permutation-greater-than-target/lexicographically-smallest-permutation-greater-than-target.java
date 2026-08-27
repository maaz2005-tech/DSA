// to do
// try tree diagram of recursion
// try to solve Iterative method 

class Solution {
    // maaz2005-tech
    StringBuilder res=new StringBuilder("");
    boolean solve(StringBuilder sb,int freq[],String target,int i,boolean flag){
        if(i==target.length()){
            if(flag){
                this.res=new StringBuilder(sb);
                return true;
            }
            else{
                return false;
            }
        }
        for(char ch='a';ch<='z';ch++){
            if(freq[ch-'a']==0 ||(!flag && ch<target.charAt(i))) continue;
            sb.append(ch);
            freq[ch-'a']--;
            boolean greater=flag||ch>target.charAt(i);

            if(solve(sb,freq,target,i+1,greater)){
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
            freq[ch-'a']++;
        }
        return false;
    }
    public String lexGreaterPermutation(String s, String target) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        solve(new StringBuilder(),freq,target,0,false);
        return res.toString();
    }
}