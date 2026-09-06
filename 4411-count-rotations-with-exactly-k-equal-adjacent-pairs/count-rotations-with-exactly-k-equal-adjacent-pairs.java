class Solution {
    public int countRotations(String s, int k) {
        String doubled=s+s;
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int score=0;
            for(int j=i;j<(n+i-1);j++){
                if(doubled.charAt(j)==doubled.charAt(j+1)){
                    score++;
                }
            }
            if(score==k) {
                ans++;
            }
        }
        return ans;
    }
}