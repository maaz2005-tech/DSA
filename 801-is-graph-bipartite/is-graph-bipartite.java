class Solution {
    boolean dfs(int graph[][],int u,int col[],int color){
        col[u]=1-color;
        for(int v:graph[u]){
            if(col[v]==col[u]) return false;
            else if(col[v]==-1 && !dfs(graph,v,col,1-color)) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int col[]=new int[n];
        Arrays.fill(col,-1);
        for(int i=0;i<n;i++){
            if(col[i]==-1){
                if(!dfs(graph,i,col,1)) return false;
            }
        }
        return true;
    }
}