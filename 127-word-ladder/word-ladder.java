class Solution {
    // int dfs(String curr,String endWord,List<String> wordList ,Set<String> vis){
    //     if(curr.equals(endWord)) return 1;
    //     vis.add(curr);
    //     StringBuilder sb=new StringBuilder(curr);
    //     int ans=Integer.MAX_VALUE;
    //     for(int i=0;i<curr.length();i++){
    //         for(char ch='a';ch<='z';ch++){
    //             sb.setCharAt(i,ch);
    //             String temp=sb.toString();
    //             if(wordList.contains(temp) && !vis.contains(temp)){
    //                 ans=Math.min(ans,dfs(temp,endWord,wordList,vis));
    //             }
    //         }
    //         sb.setCharAt(i,curr.charAt(i));
    //     }
    //     vis.remove(curr);

    //     return ans==Integer.MAX_VALUE?ans:ans+1;
    // }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // int ans=dfs(beginWord,endWord,wordList,new HashSet<>());
        int ans=1;
        Map<String,Boolean> vis=new HashMap<>();
        for(String s:wordList) vis.put(s,false);
        vis.put(beginWord,true);
        Queue<String> q=new LinkedList<>();
        int n=beginWord.length();
        q.add(beginWord);
        q.add("");
        while(!q.isEmpty()){
            String curr=q.remove();
            if(curr.equals("")){
                if(q.isEmpty()) return 0;
                else{
                    q.add("");
                    ans++;
                }
            }
            else{
                if(curr.equals(endWord)) return ans;
                StringBuilder sb=new StringBuilder(curr);
                for(int i=0;i<n;i++){
                    for(char ch='a';ch<='z';ch++){
                        sb.setCharAt(i,ch);
                        String temp=sb.toString();
                        if(vis.containsKey(temp) && !vis.get(temp)){
                            q.add(temp);
                            vis.put(temp,true);
                        }
                    }
                    sb.setCharAt(i,curr.charAt(i));
                }
            }
        }
        return 0;
    }
}