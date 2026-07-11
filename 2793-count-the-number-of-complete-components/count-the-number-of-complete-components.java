class Solution {
    // Maaz Zaki
    void createGraph(int edges[][],List<Integer> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
            graph[i].add(i);
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }
    }
    boolean dfs(List<Integer> graph[],int curr,boolean[] vis,int e){
        vis[curr]=true;
        boolean res=true;
        for(int v:graph[curr]){
            if(!vis[v] && !dfs(graph,v,vis,e)){
                res=false;
            }
        }
        return graph[curr].size()!=e?false:res;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        boolean vis[]=new boolean[n];
        List<Integer> graph[]=new ArrayList[n];
        createGraph(edges,graph);
        int ans=0;
        HashMap<List<Integer>,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            List<Integer> neighbors=graph[i];
            Collections.sort(neighbors);
            map.put(neighbors,map.getOrDefault(neighbors,0)+1);
        }
        for(List<Integer> key:map.keySet()){
            if(key.size()==map.get(key)){
                ans++;
            }
        }
        return ans;
    }
}