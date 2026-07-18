class Solution {
    void createGraph(int[][] prereq,List<Integer> graph[],int indeg[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        for(int course[]:prereq){
            int u=course[0];
            int v=course[1];
            indeg[v]++;
            graph[u].add(v);
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> graph[]=new ArrayList[numCourses];
        int indeg[]=new int[numCourses];
        createGraph(prerequisites,graph,indeg);
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int u=q.remove();
            count++;
            for(int v:graph[u]){
                indeg[v]--;
                if(indeg[v]==0) q.add(v);
            }
        }
        return count==numCourses;
    }
}