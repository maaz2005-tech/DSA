class Solution {
    void createGraph(int edges[][],List<Integer> graph[],int deg[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int e[]:edges){
            deg[e[0]]++;
            deg[e[1]]++;
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
    }
    boolean bfs(List<Integer> graph[],String colors,int root){
        Queue<Integer> q=new LinkedList<>();
        q.add(root);
        boolean vis[]=new boolean[graph.length];
        while(!q.isEmpty()){
            int curr=q.remove();
            vis[curr]=true;
            for(int v:graph[curr]){
                if(vis[v]) continue;
                if(colors.charAt(curr)=='R' && colors.charAt(v)!='B'){
                    return false;
                }
                if(colors.charAt(curr)=='B' && colors.charAt(v)!='W'){
                    return false;
                }
                if(colors.charAt(curr)=='W' && colors.charAt(v)!='R'){
                    return false;
                }
                q.add(v);
            }
        }
        return true;
    }
    public int findColoredRoot(int[][] edges, String colors) {
        int n=colors.length();
        List<Integer> graph[]=new ArrayList[n];
        int deg[]=new int[n];
        createGraph(edges,graph,deg);
        for(int i=0;i<n;i++){
            if(deg[i]<3 && bfs(graph,colors,i)) return i;
        }

        return -1;
    }
}