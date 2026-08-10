class Solution {

    boolean check(int k,int mat[][],int pref[][]){
        int n=mat.length,m=mat[0].length;
        int minRow=n,maxRow=-1;
        int minCol=m,maxCol=-1;
        for(int i=0;i+k<=n;i++){
            for(int j=0;j+k<=m;j++){
                int sum=pref[i+k][j+k]
                -pref[i+k][j]
                -pref[i][j+k]
                +pref[i][j];

                if(sum!=k*k){
                    continue;
                }
                minRow=Math.min(minRow,i);// 1st square starting 
                maxRow=Math.max(maxRow,i);// 2nd square
                minCol=Math.min(minCol,j);
                maxCol=Math.max(maxCol,j);
            }
        }
        if(maxRow==-1) return false;
        if(maxRow-minRow>=k || maxCol-minCol>=k) return true;
        return false;
    }

    public int maxArea(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        int pref[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pref[i+1][j+1]=mat[i][j]+
                    pref[i+1][j]+
                    pref[i][j+1]-
                    pref[i][j];
            }
        }
        int lo=0,hi=Math.min(n,m),ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(check(mid,mat,pref)){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans*ans;
    }
}