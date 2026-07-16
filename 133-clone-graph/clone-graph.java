/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> map=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        HashSet<Node> vis=new HashSet<>();
        q.add(node);
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(vis.contains(curr)) continue;
            vis.add(curr);
            Node cop=map.getOrDefault(curr,new Node(curr.val));
            if(!map.containsKey(curr)) map.put(curr,cop);
            for(Node neigh:curr.neighbors){
                if(!map.containsKey(neigh)) map.put(neigh,new Node(neigh.val));
                cop.neighbors.add(map.get(neigh));
                q.add(neigh);
            }
        }
        return map.get(node);
    }
}