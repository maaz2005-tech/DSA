class Solution {
    class Edge{
        int u,v,t;
        public Edge(int u,int v,int t){
            this.u=u;
            this.v=v;
            this.t=t;
        }
    }
    public long[] earliestActivationTimes(int n, int[][] edges, int[] requiredSignals) {
        List<Edge> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        for(int[] e:edges){
            graph[e[0]].add(new Edge(e[0],e[1],e[2]));
        }
        int incomingNeigh[]=new int[n];
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[]{0,0});
        boolean vis[]=new boolean[n];
        long ans[]=new long[n];
        Arrays.fill(ans,-1);
        ans[0]=0;
        vis[0]=true;
        while(!pq.isEmpty()){
            long curr[]=pq.remove();
            int u=(int)curr[0];
            long time=curr[1];
            // System.out.println(u+"|"+time);
            incomingNeigh[u]++;
            if(u!=0 && (incomingNeigh[u]!=requiredSignals[u])){
                continue;
            }
            vis[u]=true;
            ans[u]=time;
            for(Edge neigh:graph[u]){
                if(!vis[neigh.v]){
                    pq.add(new long[]{neigh.v,time+neigh.t});
                }
            }
        }
        return ans;
    }
}