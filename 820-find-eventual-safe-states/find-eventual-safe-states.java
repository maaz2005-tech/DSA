class Solution {
    boolean dfs(int graph[][],int u,boolean vis[],boolean safe[]){
        if(vis[u]) return false;
        vis[u]=true;
        for(int v:graph[u]){
            if(vis[v] && !safe[v]) return false;
            else if(!vis[v] && !safe[v] && !dfs(graph,v,vis,safe)) return false;
        }
        vis[u]=false;
        safe[u]=true;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean vis[]=new boolean[n];
        boolean safe[]=new boolean[n];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            dfs(graph,i,vis,safe);
        }
        for(int i=0;i<n;i++){
            if(safe[i]) ans.add(i);
        }
        return ans;
    }
}