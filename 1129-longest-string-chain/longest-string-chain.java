class Solution {
    boolean isPredecessor(String a,String b){
        // maaz2005-tech
        int j=b.length()-1;
        int i=a.length()-1;
        // predecessor if and only if we can insert exactly one letter anywhere in a
        boolean skipped=false;
        while(i>=0 && j>=0){
            if(b.charAt(j)!=a.charAt(i)){
                if(skipped) return false;
                skipped=true;
                j--;
            }
            else{
                i--;j--;   
            }
        }
        return (i==j && skipped)|(j==0 && !skipped);
    }
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(isPredecessor(words[j],words[i]) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
}