class Solution {
    public boolean create(char grid[][],int r,int c){
        if(r<0||r>=m || c<0 || c>=n) return false;
        if(r==m-1 && c==n-1){
            grid[r][c]='.';
            return true;
        }
        grid[r][c]='.';
        if(create(grid,r+1,c)){
            return true;
        }
        if(create(grid,r,c+1)) return true;
        grid[r][c]='#';
        return false;
    }
    int m,n;
    public String[] createGrid(int m, int n) {
        this.m=m;this.n=n;
        char[][] grid=new char[m][n];
        for(char[] g:grid) Arrays.fill(g,'#');
        create(grid,0,0);
        String[] res=new String[m];
        for(int i=0;i<m;i++){
            res[i]=new String(grid[i]);
        }
        return res;
    }
}