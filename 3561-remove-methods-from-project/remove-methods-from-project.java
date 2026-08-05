class Solution {
    void createGraph(int[][] invocations,List<Integer> graph[]){
        for(int i=0;i<graph.length;i++) graph[i]=new ArrayList<>();
        for(int invocation[]:invocations){
            graph[invocation[0]].add(invocation[1]);
        }
    }
    void dfs(List<Integer> graph[],int u,boolean vis[]){
        vis[u]=true;
        for(int v:graph[u]){
            if(!vis[v]){
                dfs(graph,v,vis);
            }
        }
    }
    
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ans=new ArrayList<>();
        List<Integer> graph[]=new ArrayList[n];
        boolean vis[]=new boolean[n];
        createGraph(invocations,graph);
        dfs(graph,k,vis);
        for(int inv[]:invocations){
            int caller=inv[0];
            int calle=inv[1];
            if(!vis[caller] && vis[calle]){
                List<Integer> all=new ArrayList<>();
                for(int i=0;i<n;i++) all.add(i);
                return all;
            }
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}