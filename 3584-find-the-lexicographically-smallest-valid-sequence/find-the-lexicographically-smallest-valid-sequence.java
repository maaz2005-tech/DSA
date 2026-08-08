class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        int last[]=new int[m];
        Arrays.fill(last,-1);
        int j=m-1;
        for(int i=n-1;i>=0 && j>=0 ;i--){
            if(word1.charAt(i)==word2.charAt(j)){
                last[j]=i;
                j--;
            }
        }
        int res[]=new int[m];
        boolean used=false;
        j=0;
        for(int i=0;i<n && j<m;i++){
            char curr=word1.charAt(i);
            char req=word2.charAt(j);
            boolean charMatch= curr==req;
            boolean canUseChange=!used && (j==m-1 || i<last[j+1]);
            if(charMatch || canUseChange){
                res[j]=i;
                if(!charMatch){
                    used=true;
                }
                j++;
            }
        }
        if(j<m) return new int[0];
        return res;
    }
}