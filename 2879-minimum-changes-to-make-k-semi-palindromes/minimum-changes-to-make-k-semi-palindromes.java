class Solution {
    int isPalin(String s){
        int i=0,j=s.length()-1;
        int ans=0;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) ans++;
            i++;j--;
        }
        return ans;
    }
    int isSemiPalin(String s,int n){
        // int n=s.length();
        int min=Integer.MAX_VALUE;
        for(int d=1;d<=n/2;d++){
            if(n%d!=0) continue;
            int curr=0;
            for(int i=0;i<d;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=i;j<n;j+=d){
                    sb.append(s.charAt(j));
                }
                curr+=isPalin(sb.toString());
            }
            min=Math.min(min,curr);
        }
        return min;
    }
    int solve(String s,int l,int r,int k,int dp[][][]){
        if(l==s.length()){
            if(k==0){
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(k<=0) return Integer.MAX_VALUE;
        // System.out.println(l+"|"+r+"|"+k);
        if(dp[l][r][k]!=-1) return dp[l][r][k];
        int ans=Integer.MAX_VALUE;
        for(int i=l+1;i<=r;i++){
            if (s.length() - i - 1 < 2 * (k - 1)) break;
            // int semi=isSemiPalin(s,l,i);
            int semi=isSemiPalin(s.substring(l,i+1),i-l+1);
            int callNext=solve(s,i+1,r,k-1,dp);
            if(callNext!=Integer.MAX_VALUE) ans=Math.min(ans,semi+callNext);
        }
        return dp[l][r][k]=ans;
    }

    public int minimumChanges(String s, int k) {
       int n=s.length();
        int dp[][][]=new int[n+1][n+1][k+1];
        for(int i[][]:dp) for(int j[]:i) Arrays.fill(j,-1);
        return solve(s,0,n-1,k,dp);
    }
    // int isSemiPalin(String s, int start, int end) {
    //     int n = end - start + 1;
    //     int min = Integer.MAX_VALUE;

    //     for (int d = 1; d < n; d++) {
    //         if (n % d != 0) continue;

    //         int curr = 0;

    //         for (int i = 0; i < d; i++) {
    //             int left = start + i;
    //             int right = start + i + ((n - 1 - i) / d) * d;

    //             while (left < right) {
    //                 if (s.charAt(left) != s.charAt(right))
    //                     curr++;

    //                 left += d;
    //                 right -= d;
    //             }
    //         }

    //         min = Math.min(min, curr);
    //         if (min == 0) return 0;
    //     }

    //     return min;
    // }
}