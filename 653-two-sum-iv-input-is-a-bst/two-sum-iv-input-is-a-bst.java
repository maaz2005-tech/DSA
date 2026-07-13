/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    void solve(TreeNode root,List<Integer> ino){
        if(root==null) return ;
        solve(root.left,ino);
        ino.add(root.val);
        solve(root.right,ino);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ino=new ArrayList<>();
        solve(root,ino);
        int r=ino.size()-1;
        int l=0;
        while(l<r){
            int sum=ino.get(l)+ino.get(r);
            if(sum>k){
                r--;
            }
            else if(sum==k) return true;
            else{
                l++;
            }
        }
        return false;
    }
}