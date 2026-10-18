class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int r=0,c=0;
        int i=0,j=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        while(i<n && i>=0 && j<m && j>=0 && !vis[i][j]){
            vis[i][j]=true;
            r=i;c=j;
            if(grid[i][j]=='L'){
                j--;
            }
            else if(grid[i][j]=='R'){
                j++;
            }
            else if(grid[i][j]=='U'){
                i--;
            }
            else{
                i++;
            }
        }
        return new int[]{r,c};
    }
}