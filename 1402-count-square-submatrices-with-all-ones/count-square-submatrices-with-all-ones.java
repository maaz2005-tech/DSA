class Solution {
    public int countSquares(int[][] matrix) {
        // 3 variable i,j,k k-> side length
        // pref[i][j]=mat[i][j]+pref[i-1][j]+pref[i][j-1]-pref[i-1][j-1]
        // sub square of side k sum pref[i][j]+pref[i-k][j-k] - pref[i-k][j]-pref[i][j-k]

        int ans=0,n=matrix.length,m=matrix[0].length;
        int pref[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                pref[i][j]=matrix[i-1][j-1]+pref[i-1][j]+pref[i][j-1]-pref[i-1][j-1];
            }
        }
        int size=Math.min(n,m);
        for(int k=1;k<=size;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(i<k || j<k) continue;
                    int sum=pref[i][j]-pref[i-k][j]-pref[i][j-k]+pref[i-k][j-k];
                    if(sum==k*k) ans++;
                }
            }
        }
        return ans;
    }
}