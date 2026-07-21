class Solution {
    public boolean isBipartite(int[][] graph) {
        //bfs
        Queue<int[]> q=new LinkedList<>();
        int col[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(col[i]!=0) continue;
            q.add(new int[]{i,0});
            while(!q.isEmpty()){
                int curr[]=q.remove();
                int u=curr[0];
                int color=curr[1];
                col[u]=color;
                for(int v:graph[u]){
                    if(col[v]==0){
                        q.add(new int[]{v,3-color});
                    }
                    else if(col[u]==col[v]) return false;
                }
            }
        }
        return true;
    }
}