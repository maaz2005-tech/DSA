class Solution {
    boolean solve(int c,int r, int k,String word,char[][] board){
        if(k==size){
            return true;
        }
        vis[r][c]=true;
        int dr[]={0,1,0,-1};
        int dc[]={1,0,-1,0};
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && board[nr][nc]==word.charAt(k)){
                if(solve(nc,nr,k+1,word,board)) return true;
            }
        }
        vis[r][c]=false;
        return false;
    }
    int n,m,size;
    boolean vis[][];
    public boolean exist(char[][] board, String word) {
        this.n=board.length;
        this.m=board[0].length;
        this.size=word.length();
        this.vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0) && solve(j,i,1,word,board)) return true;
            }
        }
        return false;
    }
}