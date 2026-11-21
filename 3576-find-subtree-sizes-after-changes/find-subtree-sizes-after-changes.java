class Solution {
    int dfsSize(List<Integer> graph[],int i,int answer[]){
        // System.out.println(i);
        int ans=0;
        for(int v:graph[i]){
            ans+=dfsSize(graph,v,answer);
        }
        return answer[i]=ans+1;
    }
    void dfsParent(List<Integer> graph[],int i,String s,int lastSeen[],int parent[]){
        int charI=s.charAt(i)-'a';
        int prevSeen=lastSeen[charI];
        lastSeen[charI]=i;
        for(int v:graph[i]){
            dfsParent(graph,v,s,lastSeen,parent);
        }
        if(prevSeen!=-1){
            parent[i]=prevSeen;
        }
        lastSeen[charI]=prevSeen;

    }
    public int[] findSubtreeSizes(int[] par, String s) {
        int n=par.length;
        int answer[]=new int[n];
        int[] parent=par.clone();
        List<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(parent[i]!=-1) graph[parent[i]].add(i);
        }
        int lastSeen[]=new int[26];
        Arrays.fill(lastSeen,-1);
        dfsParent(graph,0,s,lastSeen,parent);

        graph=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(parent[i]!=-1) graph[parent[i]].add(i);
        }
        dfsSize(graph,0,answer);
        return answer;
    }
}