class Solution {
    int getColor(char c){
        if(c=='R') return 0;
        if(c=='B') return 1;
        return 2;
    }

    public int findColoredRoot(int[][] edges, String colors) {
        int n=colors.length();
        int indeg[]=new int[n];
        int deg[]=new int[n];
        for(int e[]:edges){
            int colU=getColor(colors.charAt(e[0]));
            int colV=getColor(colors.charAt(e[1]));
            deg[e[0]]++;deg[e[1]]++;
            if(colU==colV) return -1;
            if((colU+1)%3==colV){
                indeg[e[1]]++;
            }
            else{
                indeg[e[0]]++;
            }
        }
        int root=-1;
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                if(root!=-1){
                    return -1;
                }
                root=i;
            }
        }
        
        return (root!=-1 && deg[root]<3)?root:-1;
    }
}