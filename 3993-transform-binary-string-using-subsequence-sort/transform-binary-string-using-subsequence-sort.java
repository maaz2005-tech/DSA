class Solution {

    boolean solve(String s,String str,int diff1,int diff0){
        int so=0,stro=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') so++;
            if(str.charAt(i)=='1') stro++;
            else if(str.charAt(i)=='?'){
                if(diff0==0){
                    stro++;
                }
                else diff0--;
            }

            if(stro>so) return false;
        }
        return true;
    }
    public boolean[] transformStr(String s, String[] strs) {
        int n=strs.length;
        int count[]=new int[2];
        for(char ch:s.toCharArray()){
            count[ch-'0']++;
        }
        boolean ans[]=new boolean[n];
        for(int i=0;i<n;i++){
            String str=strs[i];
            int one=0,zero=0,t=0;
            for(char ch:str.toCharArray()){
                if(ch=='?') t++;
                else if(ch=='1') one++;
                else zero++;
            }
            if(count[0]<zero || count[1]<one) ans[i]=false;
            else{
                
                int diff1=count[1]-one;
                int diff0=count[0]-zero;
                ans[i]=solve(s,str,diff1,diff0);
                
            }
        }
        return ans;
    }
}