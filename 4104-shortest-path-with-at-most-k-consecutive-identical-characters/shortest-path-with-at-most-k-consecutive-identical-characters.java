class Solution {
    class Edge{
        int v,w;
        public Edge(int v,int w){
            this.v=v;
            this.w=w;
        }
    }
    void createGraph(int edges[][],List<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int e[]:edges){
            graph[e[0]].add(new Edge(e[1],e[2]));
        }
    }
    class Info implements Comparable<Info>{
        int node;
        int freq;
        int d;
        public Info(int e,int f,int d){
            this.node=e;
            this.freq=f;
            this.d=d;
        }
        @Override
        public int compareTo(Info i){
            return this.d-i.d;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<Edge> graph[]=new ArrayList[n];
        createGraph(edges,graph);
        int dist[][]=new int[n][k+1];
        for(int i[]:dist) Arrays.fill(i,Integer.MAX_VALUE);
        Arrays.fill(dist[0],0);
        PriorityQueue<Info> q=new PriorityQueue<>();
        q.add(new Info(0,1,0));
        while(!q.isEmpty()){
            Info curr=q.remove();
            // System.out.println(graph[curr.node]);
            for(Edge e:graph[curr.node]){
                if(labels.charAt(curr.node)!=labels.charAt(e.v)){
                    int min=Integer.MAX_VALUE;
                    for(int i:dist[curr.node]) min=Math.min(min,i);
                    if(dist[e.v][1]>min+e.w){
                    //     System.out.println("I am here");
                        dist[e.v][1]=min+e.w;
                        q.add(new Info(e.v,1,dist[curr.node][1]));
                    }
                }
                else if(curr.freq<k){
                    if(dist[e.v][curr.freq+1]>dist[curr.node][curr.freq]+e.w){
                    //     System.out.println("I am here");
                        dist[e.v][curr.freq+1]=dist[curr.node][curr.freq]+e.w;
                        q.add(new Info(e.v,curr.freq+1,dist[curr.node][1]));
                    }
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int x:dist[n-1]) ans=Math.min(ans,x);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}